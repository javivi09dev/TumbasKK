package powercyphe.coffins.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import powercyphe.coffins.block.entity.CoffinBlockEntity;

public class CoffinScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public CoffinScreenHandler(int syncId, PlayerInventory inventory) {
        this(syncId, inventory, new SimpleInventory(54));
    }

    public CoffinScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ModScreenHandlers.COFFIN_SCREEN_HANDLER, syncId);
        checkSize(inventory, 54);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        int i = (6 - 4) * 18;

        int j;
        int k;
        for(j = 0; j < 6; ++j) {
            for(k = 0; k < 9; ++k) {
                this.addSlot(new Slot(inventory, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }
        for(j = 0; j < 3; ++j) {
            for(k = 0; k < 9; ++k) {
                this.addSlot(new Slot(playerInventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
            }
        }

        for(j = 0; j < 9; ++j) {
            this.addSlot(new Slot(playerInventory, j, 8 + j * 18, 161 + i));
        }
    }

    public void close(PlayerEntity player) {
        if (!player.getWorld().isClient) {
            inventory.onClose(player);
        }
    }

    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot selectedSlot = this.slots.get(slot);
        
        if (selectedSlot != null && selectedSlot.hasStack()) {
            ItemStack itemStack2 = selectedSlot.getStack();
            itemStack = itemStack2.copy();
            
            if (slot < this.inventory.size()) {
                if (!this.insertItem(itemStack2, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemStack2, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }
            
            if (itemStack2.isEmpty()) {
                selectedSlot.setStack(ItemStack.EMPTY);
            } else {
                selectedSlot.markDirty();
            }
        }
        
        return itemStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        if (CoffinBlockEntity.class.isAssignableFrom(this.inventory.getClass())) {
            CoffinBlockEntity coffinBlockEntity = (CoffinBlockEntity) this.inventory;
            if (coffinBlockEntity.isRemoved()) {
                return false;
            }
        }
        return this.inventory.canPlayerUse(player);
    }
}