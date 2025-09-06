package com.rosemods.windswept.core.other.events;

import com.rosemods.windswept.core.registry.WindsweptBlocks;
import com.rosemods.windswept.core.registry.WindsweptItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades.ItemsForEmeralds;

public class WindsweptTradeEvents {

    public static void registerTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(1, listings -> {
            listings.add(new ItemsForEmeralds(WindsweptBlocks.HOLLY_SAPLING.asItem(), 5, 1, 8, 1));
            listings.add(new ItemsForEmeralds(WindsweptBlocks.CHESTNUT_SAPLING.asItem(), 5, 1, 8, 1));
            listings.add(new ItemsForEmeralds(WindsweptBlocks.PINE_SAPLING.asItem(), 5, 1, 8, 1 ));
            listings.add(new ItemsForEmeralds(WindsweptBlocks.PINECONE.asItem(), 1, 4, 12, 1));
            listings.add(new ItemsForEmeralds(WindsweptItems.WILD_BERRIES, 1, 1, 4, 1));
            listings.add(new ItemsForEmeralds(WindsweptItems.HOLLY_BERRIES, 1, 1, 4, 1));
            listings.add(new ItemsForEmeralds(WindsweptItems.ROASTED_CHESTNUTS, 1, 1, 4, 1));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, listings -> {
            listings.add(new ItemsForEmeralds(WindsweptItems.WILD_BERRIES, 1, 4, 12, 10));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 1, listings -> {
            listings.add(new ItemsForEmeralds(WindsweptItems.GOAT, 12, 1, 16, 20));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 3, listings -> {
            listings.add(new ItemsForEmeralds(WindsweptItems.GOAT_STEW, 12, 1, 4, 20));
            listings.add(new ItemsForEmeralds(WindsweptItems.COOKED_GOAT, 1, 5, 16, 10));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LEATHERWORKER, 4, listings -> {
            listings.add(new ItemsForEmeralds(WindsweptItems.SNOW_BOOTS, 1, 5, 1, 20));
        });

        // TODO: Readd the replacement of Spruce boats in Snowy fishermen with Chestnut boats
    }
}
