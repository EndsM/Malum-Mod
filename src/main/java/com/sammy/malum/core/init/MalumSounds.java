package com.sammy.malum.core.init;

import com.sammy.malum.MalumHelper;
import net.minecraft.block.SoundType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sammy.malum.MalumMod.MODID;

public class MalumSounds
{
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);
    public static final SoundEvent TAINTED_ROCK_BREAK = new SoundEvent(MalumHelper.prefix("tainted_rock_break"));
    public static final SoundEvent TAINTED_ROCK_PLACE = new SoundEvent(MalumHelper.prefix("tainted_rock_break"));
    public static final SoundEvent TAINTED_ROCK_STEP = new SoundEvent(MalumHelper.prefix("tainted_rock_step"));
    public static final SoundEvent TAINTED_ROCK_HIT = new SoundEvent(MalumHelper.prefix("tainted_rock_hit"));
    
    public static final SoundEvent TRANSMISSIVE_ALLOY_BREAK = new SoundEvent(MalumHelper.prefix("transmissive_alloy_break"));
    public static final SoundEvent TRANSMISSIVE_ALLOY_HIT = new SoundEvent(MalumHelper.prefix("transmissive_alloy_hit"));
    public static final SoundEvent TRANSMISSIVE_ALLOY_PLACE = new SoundEvent(MalumHelper.prefix("transmissive_alloy_place"));
    public static final SoundEvent TRANSMISSIVE_ALLOY_STEP = new SoundEvent(MalumHelper.prefix("transmissive_alloy_step"));
    
    public static final SoundEvent SPIRITED_STEEL_BREAK = new SoundEvent(MalumHelper.prefix("spirited_steel_break"));
    public static final SoundEvent SPIRITED_STEEL_HIT = new SoundEvent(MalumHelper.prefix("spirited_steel_hit"));
    public static final SoundEvent SPIRITED_STEEL_PLACE = new SoundEvent(MalumHelper.prefix("spirited_steel_place"));
    public static final SoundEvent SPIRITED_STEEL_STEP = new SoundEvent(MalumHelper.prefix("spirited_steel_step"));
    
    public static final SoundEvent ABSTRUSE_BLOCK_RETURN = new SoundEvent(MalumHelper.prefix("abstruse_block_return"));
    public static final SoundEvent TAINT_SPREAD = new SoundEvent(MalumHelper.prefix("taint_spread"));
    public static final SoundEvent SCYTHE_STRIKE = new SoundEvent(MalumHelper.prefix("scythe_strike"));
    public static final SoundEvent SPIRIT_HARVEST = new SoundEvent(MalumHelper.prefix("spirit_harvest"));
    
    public static final SoundEvent SPIRIT_KILN_CONSUME = new SoundEvent(MalumHelper.prefix("spirit_kiln_consume"));
    public static final SoundEvent SPIRIT_KILN_FAIL = new SoundEvent(MalumHelper.prefix("spirit_kiln_fail"));
    public static final SoundEvent SPIRIT_KILN_FINISH = new SoundEvent(MalumHelper.prefix("spirit_kiln_finish"));
    public static final SoundEvent SPIRIT_KILN_REPAIR = new SoundEvent(MalumHelper.prefix("spirit_kiln_repair"));
    public static final SoundEvent SPIRIT_KILN_FUEL = new SoundEvent(MalumHelper.prefix("spirit_kiln_fuel"));
    
    public static final SoundEvent KARMIC_HOLDER_ACTIVATE = new SoundEvent(MalumHelper.prefix("karmic_holder_activate"));
    public static final SoundEvent DRIFT_BOOTS_JUMP = new SoundEvent(MalumHelper.prefix("drift_boots_jump"));
    
    public static final SoundType TAINTED_ROCK = new SoundType(1.0F, 1.0F, TAINTED_ROCK_BREAK, TAINTED_ROCK_STEP, TAINTED_ROCK_PLACE, TAINTED_ROCK_HIT, SoundEvents.BLOCK_BASALT_FALL);
    public static final SoundType DARKENED_ROCK = new SoundType(1.0F, 0.75F, TAINTED_ROCK_BREAK, TAINTED_ROCK_STEP, TAINTED_ROCK_PLACE, TAINTED_ROCK_HIT, SoundEvents.BLOCK_BASALT_FALL);
    public static final SoundType TRANSMISSIVE_ALLOY = new SoundType(1.0F, 1.0F, TRANSMISSIVE_ALLOY_BREAK, TRANSMISSIVE_ALLOY_STEP, TRANSMISSIVE_ALLOY_PLACE, TRANSMISSIVE_ALLOY_HIT, SoundEvents.BLOCK_STONE_FALL);
    public static final SoundType SPIRITED_STEEL_BLOCK = new SoundType(1.0F, 1.0F, SPIRITED_STEEL_BREAK, SPIRITED_STEEL_STEP, SPIRITED_STEEL_PLACE, SPIRITED_STEEL_HIT, SoundEvents.BLOCK_STONE_FALL);
    
    public static void init()
    {
        SOUNDS.register("tainted_rock_break", ()-> TAINTED_ROCK_BREAK);
        SOUNDS.register("tainted_rock_place", ()-> TAINTED_ROCK_PLACE);
        SOUNDS.register("tainted_rock_step", ()-> TAINTED_ROCK_STEP);
        SOUNDS.register("tainted_rock_hit", ()-> TAINTED_ROCK_HIT);
        
        SOUNDS.register("transmissive_alloy_break", ()-> TRANSMISSIVE_ALLOY_BREAK);
        SOUNDS.register("transmissive_alloy_hit", ()-> TRANSMISSIVE_ALLOY_HIT);
        SOUNDS.register("transmissive_alloy_place", ()-> TRANSMISSIVE_ALLOY_PLACE);
        SOUNDS.register("transmissive_alloy_step", ()-> TRANSMISSIVE_ALLOY_STEP);
        
        SOUNDS.register("spirited_steel_break", ()-> SPIRITED_STEEL_BREAK);
        SOUNDS.register("spirited_steel_hit", ()-> SPIRITED_STEEL_HIT);
        SOUNDS.register("spirited_steel_place", ()-> SPIRITED_STEEL_PLACE);
        SOUNDS.register("spirited_steel_step", ()-> SPIRITED_STEEL_STEP);
        
        SOUNDS.register("abstruse_block_return", ()-> ABSTRUSE_BLOCK_RETURN);
        SOUNDS.register("taint_spread", ()-> TAINT_SPREAD);
        SOUNDS.register("scythe_strike", ()-> SCYTHE_STRIKE);
        SOUNDS.register("spirit_harvest", ()-> SPIRIT_HARVEST);
        
        SOUNDS.register("spirit_kiln_consume", ()-> SPIRIT_KILN_CONSUME);
        SOUNDS.register("spirit_kiln_fail", ()-> SPIRIT_KILN_FAIL);
        SOUNDS.register("spirit_kiln_finish", ()-> SPIRIT_KILN_FINISH);
        SOUNDS.register("spirit_kiln_repair", ()-> SPIRIT_KILN_REPAIR);
        SOUNDS.register("spirit_kiln_fuel", ()-> SPIRIT_KILN_FUEL);
    
        SOUNDS.register("karmic_holder_activate", ()-> KARMIC_HOLDER_ACTIVATE);
        SOUNDS.register("drift_boots_jump", ()-> DRIFT_BOOTS_JUMP);
    }
}