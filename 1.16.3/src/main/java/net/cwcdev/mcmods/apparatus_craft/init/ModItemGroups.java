package net.cwcdev.mcmods.apparatus_craft.init;

import net.cwcdev.mcmods.apparatus_craft.ApparatusCraft;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class ModItemGroups {
	public static final ItemGroup MOD_ITEM_GROUP = new ModItemGroup(ApparatusCraft.MODID, () -> new ItemStack(ModItems.MACHINE_FRAME.get()));

	public static class ModItemGroup extends ItemGroup {
		private final Supplier<ItemStack> iconSupplier;

		public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier) {
			super(name);
			this.iconSupplier = iconSupplier;
		}

		@Override
		public ItemStack createIcon() {
			return iconSupplier.get();
		}
	}
}
