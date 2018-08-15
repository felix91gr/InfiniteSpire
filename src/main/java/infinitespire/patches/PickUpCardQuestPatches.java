package infinitespire.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;

import infinitespire.InfiniteSpire;
import infinitespire.abstracts.Quest;
import infinitespire.quests.PickUpCardQuest;

public class PickUpCardQuestPatches {
	@SpirePatch(cls="com.megacrit.cardcrawl.vfx.FastCardObtainEffect", method = "update")
	public static class FastCardObtainPatch {
		//rloc 7
		@SpireInsertPatch(rloc = 7, localvars = {"card"})
		public static void Insert(Object __instance, AbstractCard card) {
			for(int i = InfiniteSpire.questLog.size() - 1; i >= 0; i--) {
				Quest q = InfiniteSpire.questLog.get(i);
				if(q instanceof PickUpCardQuest) {
					PickUpCardQuest quest = ((PickUpCardQuest) q);
					if(quest.cardID.equals(card.cardID)) {
						quest.incrementQuestSteps();
						return;
					}
				}
			}
		}
	}
	
	@SpirePatch(cls="com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect", method = "update")
	public static class ShowCardAndObtainPatch {
		//rloc 7
		@SpireInsertPatch(rloc = 7, localvars = {"card"})
		public static void Insert(Object __instance, AbstractCard card) {
			for(int i = InfiniteSpire.questLog.size() - 1; i >= 0; i--) {
				Quest q = InfiniteSpire.questLog.get(i);
				if(q instanceof PickUpCardQuest) {
					PickUpCardQuest quest = ((PickUpCardQuest) q);
					if(quest.cardID.equals(card.cardID)) {
						quest.incrementQuestSteps();
						return;
					}
				}
			}
		}
	}
}
