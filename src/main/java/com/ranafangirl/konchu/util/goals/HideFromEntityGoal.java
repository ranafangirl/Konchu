package com.ranafangirl.konchu.util.goals;

import java.util.EnumSet;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Animal;

public class HideFromEntityGoal extends Goal {
	protected final Animal mob;
	protected final double speedModifier;

	public HideFromEntityGoal(Animal entity, double d) {
		this.mob = entity;
		this.speedModifier = d;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE));
	}

	@Override
	public boolean canUse() {
		if (this.mob.getSensing() == null) {
		return false;
		} else {
			if (this.mob.getLastHurtByMob() != null) {
	        	return true;		
			}
		}
        return this.stopMovement();
	}

	private boolean stopMovement() {
        this.mob.xxa = 0.0F;
        this.mob.zza = 0.0F;
        return false;
	}
}
