package net.cwcdev.mcmods.apparatus_craft.init;

import net.cwcdev.mcmods.apparatus_craft.commands.LocateBlockCommand;
import net.cwcdev.mcmods.apparatus_craft.commands.ModCommandSide;
import net.minecraft.command.CommandSource;
import com.mojang.brigadier.CommandDispatcher;

public class ModCommands {
	public static void register(CommandDispatcher<CommandSource> dispatcher, ModCommandSide side) {
		if(side == ModCommandSide.CLIENT_ONLY) {

		}

		if(side == ModCommandSide.SERVER_ONLY) {

		}

		// Both
		LocateBlockCommand.register(dispatcher, side);
	}
}
