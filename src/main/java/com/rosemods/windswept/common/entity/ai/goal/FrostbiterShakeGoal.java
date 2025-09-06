package com.rosemods.windswept.common.entity.ai.goal;

import com.rosemods.windswept.common.entity.Frostbiter;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

// TODO: FIX
public class FrostbiterShakeGoal extends Goal {
    private final Frostbiter frostbiter;
    private int tick;

    public FrostbiterShakeGoal(Frostbiter frostbiter) {
        this.frostbiter = frostbiter;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
    }

    @Override
    public boolean canUse() {
        return this.frostbiter.getRandom().nextInt(900) == 0
                && this.frostbiter.hasAntlers()
                && !this.frostbiter.isVehicle()
                && this.frostbiter.isTame();
    }

    @Override
    public boolean canContinueToUse() {
        return this.tick > 0;
    }

    @Override
    public void start() {
        this.tick = this.adjustedTickDelay(40);
        this.frostbiter.level().broadcastEntityEvent(this.frostbiter, (byte) 10);
        this.frostbiter.getNavigation().stop();
    }

    @Override
    public void stop() {
        this.tick = 0;
    }

    @Override
    public void tick() {
        this.tick = Math.max(0, this.tick - 1);

        if (this.tick == adjustedTickDelay(16)) this.frostbiter.dropRandomAntler();
        if (this.tick > adjustedTickDelay(24)) this.frostbiter.spawnAntlerParticle();

        if (this.frostbiter.isTame() && this.tick % 2 == 0 && this.tick > adjustedTickDelay(20) && this.tick < adjustedTickDelay(30))
            this.frostbiter.playSound(SoundEvents.BELL_BLOCK, .5f, .5f);

    }

}
