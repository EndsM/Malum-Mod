package com.sammy.malum.client.screen.codex.pages;

import com.sammy.malum.client.screen.codex.*;
import net.minecraft.world.item.*;

import java.util.function.*;

public final class EntryReference {
    public final ItemStack icon;
    public final BookEntry entry;

    public EntryReference(ItemStack icon, BookEntry entry) {
        this.icon = icon;
        this.entry = entry;
    }

    public EntryReference(Item icon, BookEntry entry) {
        this(icon.getDefaultInstance(), entry);
    }

    public EntryReference(ItemStack icon, BookEntryBuilder builder) {
        this(icon, builder.build());
    }

    public EntryReference(Supplier<Item> icon, BookEntry entry) {
        this(icon.get(), entry);
    }

    public EntryReference(Item icon, BookEntryBuilder builder) {
        this(icon, builder.build());
    }

    public EntryReference(Supplier<Item> icon, BookEntryBuilder builder) {
        this(icon.get(), builder);
    }
}