package net.cwcdev.mcmods.apparatus_craft.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.cwcdev.mcmods.apparatus_craft.ApparatusCraft;
import net.minecraft.block.BlockState;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.BlockStateArgument;
import net.minecraft.command.arguments.Vec3Argument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.io.FileWriter;

// TODO: Test and confirm side support for command; I wonder if a custom Predicate<CommandSource> can be used for preventing use of restricted arg-paths?
// TODO: BUG - I disabled <player> arguments, because they were throwing an exception; even if other arg-paths were valid.

public class LocateBlockCommand {
   private static final String name = "locateblock";

   private static final Logger LOGGER = LogManager.getLogger();
   private static final SimpleCommandExceptionType FAILED_EXCEPTION = new SimpleCommandExceptionType(new TranslationTextComponent("commands.locateblock.failed"));

   public static void register(CommandDispatcher<CommandSource> dispatcher, ModCommandSide side) {
      log("Registering "+(side == null ? "Server/Client" : side.name())+" ModCommand: "+name);

      LiteralArgumentBuilder<CommandSource> argumentBuilder = Commands.literal(name).requires(ctx -> ctx.hasPermissionLevel(2));

      // CLIENT
      //
      if(side == ModCommandSide.CLIENT_ONLY) {
         // locateblock <block> [...]
         argumentBuilder.then(Commands.argument("block", BlockStateArgument.blockState())
            .executes(ctx -> searchForBlock(ctx, BlockStateArgument.getBlockState(ctx, "block").getState(), 16, ctx.getSource().asPlayer()))

            // locate <block> <radius> [...]
            .then(Commands.argument("radius", IntegerArgumentType.integer(0))
               .executes(ctx -> searchForBlock(ctx, BlockStateArgument.getBlockState(ctx, "block").getState(), IntegerArgumentType.getInteger(ctx, "radius"), ctx.getSource().asPlayer()))

               // locate <block> <radius> <ofLocation>
               .then(Commands.argument("ofLocation", Vec3Argument.vec3()).executes(ctx -> searchForBlock(ctx, BlockStateArgument.getBlockState(ctx, "block").getState(), IntegerArgumentType.getInteger(ctx, "radius"), Vec3Argument.getVec3(ctx, "ofLocation"))))

               // locate <block> <radius> <ofPlayer>
               //.then(Commands.argument("ofPlayer", EntityArgument.players()).executes(ctx -> searchForBlock(ctx, BlockStateArgument.getBlockState(ctx, "block").getState(), IntegerArgumentType.getInteger(ctx, "radius"), EntityArgument.getPlayer(ctx, "ofPlayer"))))
            )

            // locate <block> <location>
            .then(Commands.argument("location", Vec3Argument.vec3()).executes(ctx -> searchForBlock(ctx, BlockStateArgument.getBlockState(ctx, "block").getState(), 16, Vec3Argument.getVec3(ctx, "location"))))

            // locate <block> <player>
            //.then(Commands.argument("player", EntityArgument.players()).executes(ctx -> searchForBlock(ctx, BlockStateArgument.getBlockState(ctx, "block").getState(), 16, EntityArgument.getPlayer(ctx, "player"))))
         );
      } else if(side == ModCommandSide.SERVER_ONLY) {
         // locateblock <block> [...]
         argumentBuilder.then(Commands.argument("block", BlockStateArgument.blockState())
            // locate <block> <radius> [...]
            .then(Commands.argument("radius", IntegerArgumentType.integer(0))
               // locate <block> <radius> <ofLocation>
               .then(Commands.argument("ofLocation", Vec3Argument.vec3()).executes(ctx -> searchForBlock(ctx, BlockStateArgument.getBlockState(ctx, "block").getState(), IntegerArgumentType.getInteger(ctx, "radius"), Vec3Argument.getVec3(ctx, "ofLocation"))))

               // locate <block> <radius> <ofPlayer>
               //.then(Commands.argument("ofPlayer", EntityArgument.players()).executes(ctx -> searchForBlock(ctx, BlockStateArgument.getBlockState(ctx, "block").getState(), IntegerArgumentType.getInteger(ctx, "radius"), EntityArgument.getPlayer(ctx, "ofPlayer"))))
            )

            // locate <block> <location>
            .then(Commands.argument("location", Vec3Argument.vec3()).executes(ctx -> searchForBlock(ctx, BlockStateArgument.getBlockState(ctx, "block").getState(), 16, Vec3Argument.getVec3(ctx, "location"))))

            // locate <block> <player>
            //.then(Commands.argument("player", EntityArgument.players()).executes(ctx -> searchForBlock(ctx, BlockStateArgument.getBlockState(ctx, "block").getState(), 16, EntityArgument.getPlayer(ctx, "player"))))
         );
      }
      dispatcher.register(argumentBuilder);


      if(ApparatusCraft.IS_DEV) {
         registerTest(dispatcher, side);
      }
   }

   private static int searchForBlock(CommandContext<CommandSource> ctx, BlockState needle, int maxRadius, ServerPlayerEntity player) {
      BlockPos playerPos = new BlockPos(player.getPosX(), player.getPosY(), player.getPosZ());
      return searchForBlock(ctx, needle, maxRadius, playerPos.getX(), playerPos.getY(), playerPos.getZ());
   }
   private static int searchForBlock(CommandContext<CommandSource> ctx, BlockState needle, int maxRadius, Vector3d pos) {
      BlockPos playerPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
      return searchForBlock(ctx, needle, maxRadius, playerPos.getX(), playerPos.getY(), playerPos.getZ());
   }
   private static int searchForBlock(CommandContext<CommandSource> ctx, BlockState needle, int maxRadius, int startCoordX, int startCoordY, int startCoordZ) {
      try {
         //ServerWorld world = ctx.getSource().getWorld();
         World world = ctx.getSource().asPlayer().getEntityWorld();

         BlockPos actualPosition = null;
         TileEntity tileentity = null;
         BlockState found = null;

         boolean blockFound = false;

         clearLogFile();
         log("ModCommand \"" + name + "\" ran!");

         for (int radius = 0; radius <= maxRadius; radius++) {
            for (int localOffsetZ = -radius; localOffsetZ <= radius; localOffsetZ++) {
               int z = startCoordZ + localOffsetZ;
               boolean doFullRow = (localOffsetZ == -radius) || (localOffsetZ == radius);

               for (int localOffsetX = -radius; localOffsetX <= radius; localOffsetX++) {
                  int x = startCoordX + localOffsetX;

                  int maxYRadius = Math.max(startCoordY, 255 - startCoordY);
                  for (int yRadius = 0; yRadius < maxYRadius; yRadius++) {
                     // Check +yRadius
                     int y = startCoordY + yRadius;
                     if (y <= 255) {
                        actualPosition = new BlockPos(x, y, z);
                        tileentity = world.getTileEntity(actualPosition);
                        if(tileentity == null) {
                           found = world.getBlockState(actualPosition);
                        } else {
                           found = tileentity.getBlockState();
                        }
                        blockFound = compareBlockStates(needle, found, actualPosition);
                     }

                     if (!blockFound && yRadius != 0) {
                        // Check -yOffset
                        y = startCoordY - yRadius;
                        if (y < 0) continue;

                        actualPosition = new BlockPos(x, y, z);
                        tileentity = world.getTileEntity(actualPosition);
                        if(tileentity == null) {
                           found = world.getBlockState(actualPosition);
                        } else {
                           found = tileentity.getBlockState();
                        }
                        blockFound = compareBlockStates(needle, found, actualPosition);
                     }

                     if (blockFound) {
                        ctx.getSource().sendFeedback(new TranslationTextComponent("Block Found! ("+actualPosition.getX()+","+actualPosition.getY()+","+actualPosition.getZ()+")"), true);
                        return 0;
                     }
                  }

                  if (radius == 0) break;

                  // Skip to end, if not doing full row.
                  if (!doFullRow && (localOffsetX != radius)) localOffsetX = radius - 1;
               }

               if (radius == 0) break;
            }
         }

         throw FAILED_EXCEPTION.create();
      } catch (Exception exception) {
         LOGGER.error("An error occured w/command "+name);
         if(ApparatusCraft.IS_DEV && ApparatusCraft.DEV_VERBOSITY > 0) {
            LOGGER.error(exception);
            Arrays.stream(exception.getStackTrace()).iterator().forEachRemaining(stackTraceElement -> {
               LOGGER.error(stackTraceElement.getFileName() + " in " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + " (Line: " + stackTraceElement.getLineNumber() + ")");
            });
         }
      }

      return 1;
   }

   private static boolean compareBlockStates(BlockState needle, BlockState found, BlockPos pos) {
      if(needle.getBlock().getRegistryName() == found.getBlock().getRegistryName()) {
         log("Block Found! ("+pos.getX()+","+pos.getY()+","+pos.getZ()+")");
         return true;
      } else if(found != null) {
         log("Searching! ("+pos.getX()+","+pos.getY()+","+pos.getZ()+") - "+found.getBlock().getRegistryName());
      } else {
         log("Searching! ("+pos.getX()+","+pos.getY()+","+pos.getZ()+") - No Block Found.");
      }

      return false;
   }


   // Test Commands
   //
   private static void registerTest(CommandDispatcher<CommandSource> dispatcher, ModCommandSide side) {
      dispatcher.register(Commands.literal("test"+name+"1").requires(ctx -> ctx.hasPermissionLevel(2)).then(Commands.argument("size", IntegerArgumentType.integer()).executes(ctx -> {
         clearLogFile();

         int size = IntegerArgumentType.getInteger(ctx, "size");

         int localStartX = (int)(size / 2);
         int localStartZ = (int)(size / 2);

         int count = 1;
         int[][] map = new int[size][size];

         int maxRadius = (int)Math.ceil(size / 2);

         log("size: "+size+'x'+size);
         log("localStartPos: ("+localStartX+','+localStartZ+")");
         log("maxRadius: "+maxRadius);

         for(int radius = 0; radius <= maxRadius; radius++) {
            log("~~~~ Radius Changed! ("+radius+") ~~~~");

            for(int localOffsetZ = -radius; localOffsetZ <= radius; localOffsetZ++) {
               int z = localStartZ + localOffsetZ;
               if(z < 0 || z >= size) {
                  log("x - (?,"+localStartZ+") + (?, "+localOffsetZ+") = (?, "+z+")");
                  continue;
               }

               boolean doFullRow = (localOffsetZ == -radius) || (localOffsetZ == radius);
               log("doFullRow: "+(doFullRow ? "true" : "false")+" => ("+localOffsetZ+" == "+(-radius)+") || ("+localOffsetZ+" == "+radius+")");

               for(int localOffsetX = -radius; localOffsetX <= radius; localOffsetX++) {
                  int x = localStartX + localOffsetX;
                  if(x < 0 || x >= size) {
                     log("x - ("+localStartX+','+localStartZ+") + ("+ localOffsetX +", "+localOffsetZ+") = ("+x+", "+z+") => "+count);
                     continue;
                  } else {
                     log("√ - ("+localStartX+','+localStartZ+") + ("+ localOffsetX +", "+localOffsetZ+") = ("+x+", "+z+") => "+count);
                  }

                  try {
                     //log("Setting map["+x+"]["+z+"] = "+count);
                     map[x][z] = count;
                     logGraph(map, count, size, size);
                     count++;
                  } catch(IndexOutOfBoundsException e) {
                     log("~~~ IndexOutOfBoundsException map["+x+"]["+z+"] ~~~ ");
                     count++;
                  }

                  if(radius == 0) break;

                  // Skip to end, if not doing full row.
                  if(!doFullRow && (localOffsetX != radius)) localOffsetX = radius-1;
               }

               if(radius == 0) break;
            }
         }

         return 0;
      })));
   }

   private static void logGraph(int[][] checkedBlocks, int count) {
      logGraph(checkedBlocks, count, 16, 16);
   }

   private static void logGraph(int[][] checkedBlocks, int count, int sizeX, int sizeZ) {
      for (int z = 0; z < sizeZ; z++) {
         for (int x = 0; x < sizeX; x++) {
            String c = Integer.toString(count);
            int cLen = c.length();

            String i = Integer.toString(checkedBlocks[x][z]);
            int iLen = i.length();

            if(iLen < cLen) {
               int diff = cLen - iLen;
               for(int t = 0; t < diff; t++) {
                  i = "0"+i;
               }
            }

            log(i+" ", true);
         }
         log("");
      }

      log("\n");
   }


   // Temp Logging crap
   //
   private static FileWriter logWritter;

   public static void log(String s) {
      log(s, false);
   }

   public static void log(String s, boolean skipNewLine) {
      if(ApparatusCraft.IS_DEV && ApparatusCraft.DEV_VERBOSITY > 0) {
         LOGGER.info(s);

         /*
         if(logWritter == null) {
            try {
               logWritter = new FileWriter("/Users/zach/Desktop/ApparatusCraft/run/locateblock.txt", true);
               LOGGER.error("FileWriter Inited!");
            } catch (IOException e) {
               LOGGER.error("Failed to init FileWriter");
               e.printStackTrace();
            }
         }

         if(logWritter != null) {
            try {
               logWritter.write(s + (skipNewLine ? "" : "\n"));
               logWritter.flush();
            } catch (IOException e) {
               LOGGER.error("Failed to write to file.");
               e.printStackTrace();
            }
         }
         */
      }
   }

   public static void clearLogFile() {
      /*
      try {
         boolean resetLogWritter = false;
         if(logWritter != null) {
            resetLogWritter = true;
            logWritter.close();
         }

         FileWriter fwOb = new FileWriter("~/Desktop/ApparatusCraft/run/logs/locateblocktest.txt", false);
         PrintWriter pwOb = new PrintWriter(fwOb, false);
         pwOb.flush();
         pwOb.close();
         fwOb.close();

         if(resetLogWritter) {
            logWritter = new FileWriter("~/Desktop/ApparatusCraft/run/logs/locateblocktest.txt", true);
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
      */
   }
}