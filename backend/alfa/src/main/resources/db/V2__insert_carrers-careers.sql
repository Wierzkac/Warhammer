INSERT INTO careers_careers (career_entry, career_exit) VALUES
    -- Agitator career entries
    ((SELECT id FROM careers WHERE name = 'career.agitator.name'), (SELECT id FROM careers WHERE name = 'career.burgher.name')),
    ((SELECT id FROM careers WHERE name = 'career.agitator.name'), (SELECT id FROM careers WHERE name = 'career.captain.name')),
    ((SELECT id FROM careers WHERE name = 'career.agitator.name'), (SELECT id FROM careers WHERE name = 'career.herald.name')),
    ((SELECT id FROM careers WHERE name = 'career.agitator.name'), (SELECT id FROM careers WHERE name = 'career.highwayman.name')),
    ((SELECT id FROM careers WHERE name = 'career.agitator.name'), (SELECT id FROM careers WHERE name = 'career.scribe.name')),
    ((SELECT id FROM careers WHERE name = 'career.agitator.name'), (SELECT id FROM careers WHERE name = 'career.servant.name')),
    ((SELECT id FROM careers WHERE name = 'career.agitator.name'), (SELECT id FROM careers WHERE name = 'career.student.name')),
    ((SELECT id FROM careers WHERE name = 'career.agitator.name'), (SELECT id FROM careers WHERE name = 'career.zealot.name')),

    -- Apprentice Wizard career entries
    ((SELECT id FROM careers WHERE name = 'career.apprentice_wizard.name'), (SELECT id FROM careers WHERE name = 'career.hedge_wizard.name')),
    ((SELECT id FROM careers WHERE name = 'career.apprentice_wizard.name'), (SELECT id FROM careers WHERE name = 'career.scholar.name')),
    ((SELECT id FROM careers WHERE name = 'career.apprentice_wizard.name'), (SELECT id FROM careers WHERE name = 'career.scribe.name')),
    ((SELECT id FROM careers WHERE name = 'career.apprentice_wizard.name'), (SELECT id FROM careers WHERE name = 'career.student.name')),

    -- Bailiff career entries
    ((SELECT id FROM careers WHERE name = 'career.bailiff.name'), (SELECT id FROM careers WHERE name = 'career.bodyguard.name')),
    ((SELECT id FROM careers WHERE name = 'career.bailiff.name'), (SELECT id FROM careers WHERE name = 'career.jailer.name')),

    -- Barber Surgeon career entries
    ((SELECT id FROM careers WHERE name = 'career.barber_surgeon.name'), (SELECT id FROM careers WHERE name = 'career.initiate.name')),
    ((SELECT id FROM careers WHERE name = 'career.barber_surgeon.name'), (SELECT id FROM careers WHERE name = 'career.student.name')),

    -- Boatman career entries
    ((SELECT id FROM careers WHERE name = 'career.boatman.name'), (SELECT id FROM careers WHERE name = 'career.ferryman.name')),
    ((SELECT id FROM careers WHERE name = 'career.boatman.name'), (SELECT id FROM careers WHERE name = 'career.smuggler.name')),

    -- Bodyguard career entries
    ((SELECT id FROM careers WHERE name = 'career.bodyguard.name'), (SELECT id FROM careers WHERE name = 'career.estalian_diestro.name')),
    ((SELECT id FROM careers WHERE name = 'career.bodyguard.name'), (SELECT id FROM careers WHERE name = 'career.jailer.name')),
    ((SELECT id FROM careers WHERE name = 'career.bodyguard.name'), (SELECT id FROM careers WHERE name = 'career.mercenary.name')),
    ((SELECT id FROM careers WHERE name = 'career.bodyguard.name'), (SELECT id FROM careers WHERE name = 'career.thug.name')),

    -- Bone Picker career entries
    ((SELECT id FROM careers WHERE name = 'career.bone_picker.name'), (SELECT id FROM careers WHERE name = 'career.peasant.name')),
    ((SELECT id FROM careers WHERE name = 'career.bone_picker.name'), (SELECT id FROM careers WHERE name = 'career.rat_catcher.name')),
    ((SELECT id FROM careers WHERE name = 'career.bone_picker.name'), (SELECT id FROM careers WHERE name = 'career.vagabond.name')),

    -- Bounty Hunter career entries
    ((SELECT id FROM careers WHERE name = 'career.bounty_hunter.name'), (SELECT id FROM careers WHERE name = 'career.bodyguard.name')),
    ((SELECT id FROM careers WHERE name = 'career.bounty_hunter.name'), (SELECT id FROM careers WHERE name = 'career.fieldwarden.name')),
    ((SELECT id FROM careers WHERE name = 'career.bounty_hunter.name'), (SELECT id FROM careers WHERE name = 'career.hunter.name')),
    ((SELECT id FROM careers WHERE name = 'career.bounty_hunter.name'), (SELECT id FROM careers WHERE name = 'career.kislevite_kossar.name')),
    ((SELECT id FROM careers WHERE name = 'career.bounty_hunter.name'), (SELECT id FROM careers WHERE name = 'career.mercenary.name')),
    ((SELECT id FROM careers WHERE name = 'career.bounty_hunter.name'), (SELECT id FROM careers WHERE name = 'career.pit_fighter.name')),

    -- Burgher career entries
    ((SELECT id FROM careers WHERE name = 'career.burgher.name'), (SELECT id FROM careers WHERE name = 'career.inkeeper.name')),
    ((SELECT id FROM careers WHERE name = 'career.burgher.name'), (SELECT id FROM careers WHERE name = 'career.servant.name')),

    -- Camp Follower career entries
    ((SELECT id FROM careers WHERE name = 'career.camp_follower.name'), (SELECT id FROM careers WHERE name = 'career.bone_picker.name')),
    ((SELECT id FROM careers WHERE name = 'career.camp_follower.name'), (SELECT id FROM careers WHERE name = 'career.servant.name')),

    -- Charcoal Burner career entries
    ((SELECT id FROM careers WHERE name = 'career.charcoal_burner.name'), (SELECT id FROM careers WHERE name = 'career.camp_follower.name')),
    ((SELECT id FROM careers WHERE name = 'career.charcoal_burner.name'), (SELECT id FROM careers WHERE name = 'career.hunter.name')),
    ((SELECT id FROM careers WHERE name = 'career.charcoal_burner.name'), (SELECT id FROM careers WHERE name = 'career.miner.name')),
    ((SELECT id FROM careers WHERE name = 'career.charcoal_burner.name'), (SELECT id FROM careers WHERE name = 'career.peasant.name')),

    -- Coachman career entries
    ((SELECT id FROM careers WHERE name = 'career.coachman.name'), (SELECT id FROM careers WHERE name = 'career.outrider.name')),
    ((SELECT id FROM careers WHERE name = 'career.coachman.name'), (SELECT id FROM careers WHERE name = 'career.messenger.name')),

    -- Entertainer career entries
    ((SELECT id FROM careers WHERE name = 'career.entertainer.name'), (SELECT id FROM careers WHERE name = 'career.herald.name')),
    ((SELECT id FROM careers WHERE name = 'career.entertainer.name'), (SELECT id FROM careers WHERE name = 'career.rogue.name')),
    ((SELECT id FROM careers WHERE name = 'career.entertainer.name'), (SELECT id FROM careers WHERE name = 'career.thief.name')),
    ((SELECT id FROM careers WHERE name = 'career.entertainer.name'), (SELECT id FROM careers WHERE name = 'career.vagabond.name')),

    -- Envoy career entries
    ((SELECT id FROM careers WHERE name = 'career.envoy.name'), (SELECT id FROM careers WHERE name = 'career.student.name')),
    ((SELECT id FROM careers WHERE name = 'career.envoy.name'), (SELECT id FROM careers WHERE name = 'career.tradesman.name')),

    -- Ferryman career entries
    ((SELECT id FROM careers WHERE name = 'career.ferryman.name'), (SELECT id FROM careers WHERE name = 'career.coachman.name')),
    ((SELECT id FROM careers WHERE name = 'career.ferryman.name'), (SELECT id FROM careers WHERE name = 'career.smuggler.name')),
    ((SELECT id FROM careers WHERE name = 'career.ferryman.name'), (SELECT id FROM careers WHERE name = 'career.toll_keeper.name')),

    -- Fieldwarden career entries
    ((SELECT id FROM careers WHERE name = 'career.fieldwarden.name'), (SELECT id FROM careers WHERE name = 'career.hunter.name')),
    ((SELECT id FROM careers WHERE name = 'career.fieldwarden.name'), (SELECT id FROM careers WHERE name = 'career.militiaman.name')),
    ((SELECT id FROM careers WHERE name = 'career.fieldwarden.name'), (SELECT id FROM careers WHERE name = 'career.toll_keeper.name')),

    -- Fisherman career entries
    ((SELECT id FROM careers WHERE name = 'career.fisherman.name'), (SELECT id FROM careers WHERE name = 'career.boatman.name')),
    ((SELECT id FROM careers WHERE name = 'career.fisherman.name'), (SELECT id FROM careers WHERE name = 'career.peasant.name')),

    -- Grave Robber career entries
    ((SELECT id FROM careers WHERE name = 'career.grave_robber.name'), (SELECT id FROM careers WHERE name = 'career.barber_surgeon.name')),
    ((SELECT id FROM careers WHERE name = 'career.grave_robber.name'), (SELECT id FROM careers WHERE name = 'career.bone_picker.name')),
    ((SELECT id FROM careers WHERE name = 'career.grave_robber.name'), (SELECT id FROM careers WHERE name = 'career.rat_catcher.name')),

    -- Hunter career entries
    ((SELECT id FROM careers WHERE name = 'career.hunter.name'), (SELECT id FROM careers WHERE name = 'career.charcoal_burner.name')),
    ((SELECT id FROM careers WHERE name = 'career.hunter.name'), (SELECT id FROM careers WHERE name = 'career.kithband_warrior.name')),
    ((SELECT id FROM careers WHERE name = 'career.hunter.name'), (SELECT id FROM careers WHERE name = 'career.woodsman.name')),

    -- Initiate career entries
    ((SELECT id FROM careers WHERE name = 'career.initiate.name'), (SELECT id FROM careers WHERE name = 'career.hedge_wizard.name')),
    ((SELECT id FROM careers WHERE name = 'career.initiate.name'), (SELECT id FROM careers WHERE name = 'career.knight.name')),
    ((SELECT id FROM careers WHERE name = 'career.initiate.name'), (SELECT id FROM careers WHERE name = 'career.scribe.name')),
    ((SELECT id FROM careers WHERE name = 'career.initiate.name'), (SELECT id FROM careers WHERE name = 'career.student.name')),
    ((SELECT id FROM careers WHERE name = 'career.initiate.name'), (SELECT id FROM careers WHERE name = 'career.vampire_hunter.name')),
    ((SELECT id FROM careers WHERE name = 'career.initiate.name'), (SELECT id FROM careers WHERE name = 'career.witch_hunter.name')),
    ((SELECT id FROM careers WHERE name = 'career.initiate.name'), (SELECT id FROM careers WHERE name = 'career.zealot.name')),

    -- Jailer career entries
    ((SELECT id FROM careers WHERE name = 'career.jailer.name'), (SELECT id FROM careers WHERE name = 'career.bodyguard.name')),
    ((SELECT id FROM careers WHERE name = 'career.jailer.name'), (SELECT id FROM careers WHERE name = 'career.rat_catcher.name')),

    -- Kithband Warrior career entries
    ((SELECT id FROM careers WHERE name = 'career.kithband_warrior.name'), (SELECT id FROM careers WHERE name = 'career.hunter.name')),
    ((SELECT id FROM careers WHERE name = 'career.kithband_warrior.name'), (SELECT id FROM careers WHERE name = 'career.messenger.name')),

    -- Marine career entries
    ((SELECT id FROM careers WHERE name = 'career.marine.name'), (SELECT id FROM careers WHERE name = 'career.boatman.name')),
    ((SELECT id FROM careers WHERE name = 'career.marine.name'), (SELECT id FROM careers WHERE name = 'career.fisherman.name')),
    ((SELECT id FROM careers WHERE name = 'career.marine.name'), (SELECT id FROM careers WHERE name = 'career.seaman.name')),

    -- Mercenary career entries
    ((SELECT id FROM careers WHERE name = 'career.mercenary.name'), (SELECT id FROM careers WHERE name = 'career.bodyguard.name')),
    ((SELECT id FROM careers WHERE name = 'career.mercenary.name'), (SELECT id FROM careers WHERE name = 'career.bounty_hunter.name')),
    ((SELECT id FROM careers WHERE name = 'career.mercenary.name'), (SELECT id FROM careers WHERE name = 'career.demagogue.name')),
    ((SELECT id FROM careers WHERE name = 'career.mercenary.name'), (SELECT id FROM careers WHERE name = 'career.fieldwarden.name')),
    ((SELECT id FROM careers WHERE name = 'career.mercenary.name'), (SELECT id FROM careers WHERE name = 'career.kislevite_kossar.name')),
    ((SELECT id FROM careers WHERE name = 'career.mercenary.name'), (SELECT id FROM careers WHERE name = 'career.militiaman.name')),
    ((SELECT id FROM careers WHERE name = 'career.mercenary.name'), (SELECT id FROM careers WHERE name = 'career.miner.name')),
    ((SELECT id FROM careers WHERE name = 'career.mercenary.name'), (SELECT id FROM careers WHERE name = 'career.norse_berserker.name')),
    ((SELECT id FROM careers WHERE name = 'career.mercenary.name'), (SELECT id FROM careers WHERE name = 'career.outrider.name')),
    ((SELECT id FROM careers WHERE name = 'career.mercenary.name'), (SELECT id FROM careers WHERE name = 'career.pit_fighter.name')),
    ((SELECT id FROM careers WHERE name = 'career.mercenary.name'), (SELECT id FROM careers WHERE name = 'career.soldier.name')),
    ((SELECT id FROM careers WHERE name = 'career.mercenary.name'), (SELECT id FROM careers WHERE name = 'career.thug.name')),
    ((SELECT id FROM careers WHERE name = 'career.mercenary.name'), (SELECT id FROM careers WHERE name = 'career.watchman.name')),

    -- Messenger career entries
    ((SELECT id FROM careers WHERE name = 'career.messenger.name'), (SELECT id FROM careers WHERE name = 'career.militiaman.name')),
    ((SELECT id FROM careers WHERE name = 'career.messenger.name'), (SELECT id FROM careers WHERE name = 'career.roadwarden.name')),
    ((SELECT id FROM careers WHERE name = 'career.messenger.name'), (SELECT id FROM careers WHERE name = 'career.servant.name')),

    -- Militiaman career entries
    ((SELECT id FROM careers WHERE name = 'career.militiaman.name'), (SELECT id FROM careers WHERE name = 'career.artisan.name')),
    ((SELECT id FROM careers WHERE name = 'career.militiaman.name'), (SELECT id FROM careers WHERE name = 'career.bailiff.name')),
    ((SELECT id FROM careers WHERE name = 'career.militiaman.name'), (SELECT id FROM careers WHERE name = 'career.burgher.name')),
    ((SELECT id FROM careers WHERE name = 'career.militiaman.name'), (SELECT id FROM careers WHERE name = 'career.fisherman.name')),
    ((SELECT id FROM careers WHERE name = 'career.militiaman.name'), (SELECT id FROM careers WHERE name = 'career.merchant.name')),
    ((SELECT id FROM careers WHERE name = 'career.militiaman.name'), (SELECT id FROM careers WHERE name = 'career.peasant.name')),
    ((SELECT id FROM careers WHERE name = 'career.militiaman.name'), (SELECT id FROM careers WHERE name = 'career.tradesman.name')),
    ((SELECT id FROM careers WHERE name = 'career.militiaman.name'), (SELECT id FROM careers WHERE name = 'career.woodsman.name')),

    -- Miner career entries
    ((SELECT id FROM careers WHERE name = 'career.miner.name'), (SELECT id FROM careers WHERE name = 'career.charcoal_burner.name')),
    ((SELECT id FROM careers WHERE name = 'career.miner.name'), (SELECT id FROM careers WHERE name = 'career.hunter.name')),

    -- Noble career entries
    ((SELECT id FROM careers WHERE name = 'career.noble.name'), (SELECT id FROM careers WHERE name = 'career.squire.name')),
    ((SELECT id FROM careers WHERE name = 'career.noble.name'), (SELECT id FROM careers WHERE name = 'career.steward.name')),

    -- Outlaw career entries
    ((SELECT id FROM careers WHERE name = 'career.outlaw.name'), (SELECT id FROM careers WHERE name = 'career.agitator.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw.name'), (SELECT id FROM careers WHERE name = 'career.charlatan.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw.name'), (SELECT id FROM careers WHERE name = 'career.coachman.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw.name'), (SELECT id FROM careers WHERE name = 'career.hedge_wizard.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw.name'), (SELECT id FROM careers WHERE name = 'career.inkeeper.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw.name'), (SELECT id FROM careers WHERE name = 'career.marine.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw.name'), (SELECT id FROM careers WHERE name = 'career.mercenary.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw.name'), (SELECT id FROM careers WHERE name = 'career.militiaman.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw.name'), (SELECT id FROM careers WHERE name = 'career.peasant.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw.name'), (SELECT id FROM careers WHERE name = 'career.roadwarden.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw.name'), (SELECT id FROM careers WHERE name = 'career.rogue.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw.name'), (SELECT id FROM careers WHERE name = 'career.squire.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw.name'), (SELECT id FROM careers WHERE name = 'career.toll_keeper.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw.name'), (SELECT id FROM careers WHERE name = 'career.woodsman.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw.name'), (SELECT id FROM careers WHERE name = 'career.zealot.name')),

    -- Outrider career entries
    ((SELECT id FROM careers WHERE name = 'career.outrider.name'), (SELECT id FROM careers WHERE name = 'career.kithband_warrior.name')),
    ((SELECT id FROM careers WHERE name = 'career.outrider.name'), (SELECT id FROM careers WHERE name = 'career.messenger.name')),
    ((SELECT id FROM careers WHERE name = 'career.outrider.name'), (SELECT id FROM careers WHERE name = 'career.roadwarden.name')),
    ((SELECT id FROM careers WHERE name = 'career.outrider.name'), (SELECT id FROM careers WHERE name = 'career.soldier.name')),

    -- Pit Fighter career entries
    ((SELECT id FROM careers WHERE name = 'career.pit_fighter.name'), (SELECT id FROM careers WHERE name = 'career.norse_berserker.name')),
    ((SELECT id FROM careers WHERE name = 'career.pit_fighter.name'), (SELECT id FROM careers WHERE name = 'career.protagonist.name')),
    ((SELECT id FROM careers WHERE name = 'career.pit_fighter.name'), (SELECT id FROM careers WHERE name = 'career.shieldbreaker.name')),
    ((SELECT id FROM careers WHERE name = 'career.pit_fighter.name'), (SELECT id FROM careers WHERE name = 'career.thug.name')),

    -- Protagonist career entries
    ((SELECT id FROM careers WHERE name = 'career.protagonist.name'), (SELECT id FROM careers WHERE name = 'career.bailiff.name')),
    ((SELECT id FROM careers WHERE name = 'career.protagonist.name'), (SELECT id FROM careers WHERE name = 'career.bodyguard.name')),
    ((SELECT id FROM careers WHERE name = 'career.protagonist.name'), (SELECT id FROM careers WHERE name = 'career.bounty_hunter.name')),
    ((SELECT id FROM careers WHERE name = 'career.protagonist.name'), (SELECT id FROM careers WHERE name = 'career.estalian_diestro.name')),
    ((SELECT id FROM careers WHERE name = 'career.protagonist.name'), (SELECT id FROM careers WHERE name = 'career.pit_fighter.name')),

    -- Rat Catcher career entries
    ((SELECT id FROM careers WHERE name = 'career.rat_catcher.name'), (SELECT id FROM careers WHERE name = 'career.grave_robber.name')),
    ((SELECT id FROM careers WHERE name = 'career.rat_catcher.name'), (SELECT id FROM careers WHERE name = 'career.jailer.name')),
    ((SELECT id FROM careers WHERE name = 'career.rat_catcher.name'), (SELECT id FROM careers WHERE name = 'career.runebearer.name')),
    ((SELECT id FROM careers WHERE name = 'career.rat_catcher.name'), (SELECT id FROM careers WHERE name = 'career.tomb_robber.name')),

    -- Roadwarden career entries
    ((SELECT id FROM careers WHERE name = 'career.roadwarden.name'), (SELECT id FROM careers WHERE name = 'career.coachman.name')),
    ((SELECT id FROM careers WHERE name = 'career.roadwarden.name'), (SELECT id FROM careers WHERE name = 'career.ferryman.name')),
    ((SELECT id FROM careers WHERE name = 'career.roadwarden.name'), (SELECT id FROM careers WHERE name = 'career.messenger.name')),
    ((SELECT id FROM careers WHERE name = 'career.roadwarden.name'), (SELECT id FROM careers WHERE name = 'career.outrider.name')),
    ((SELECT id FROM careers WHERE name = 'career.roadwarden.name'), (SELECT id FROM careers WHERE name = 'career.watchman.name')),

    -- Rogue career entries
    ((SELECT id FROM careers WHERE name = 'career.rogue.name'), (SELECT id FROM careers WHERE name = 'career.agitator.name')),
    ((SELECT id FROM careers WHERE name = 'career.rogue.name'), (SELECT id FROM careers WHERE name = 'career.assassin.name')),
    ((SELECT id FROM careers WHERE name = 'career.rogue.name'), (SELECT id FROM careers WHERE name = 'career.duellist.name')),
    ((SELECT id FROM careers WHERE name = 'career.rogue.name'), (SELECT id FROM careers WHERE name = 'career.entertainer.name')),
    ((SELECT id FROM careers WHERE name = 'career.rogue.name'), (SELECT id FROM careers WHERE name = 'career.envoy.name')),
    ((SELECT id FROM careers WHERE name = 'career.rogue.name'), (SELECT id FROM careers WHERE name = 'career.estalian_diestro.name')),
    ((SELECT id FROM careers WHERE name = 'career.rogue.name'), (SELECT id FROM careers WHERE name = 'career.noble.name')),
    ((SELECT id FROM careers WHERE name = 'career.rogue.name'), (SELECT id FROM careers WHERE name = 'career.seaman.name')),
    ((SELECT id FROM careers WHERE name = 'career.rogue.name'), (SELECT id FROM careers WHERE name = 'career.thief.name')),
    ((SELECT id FROM careers WHERE name = 'career.rogue.name'), (SELECT id FROM careers WHERE name = 'career.valet.name')),

    -- Runebearer career entries
    ((SELECT id FROM careers WHERE name = 'career.runebearer.name'), (SELECT id FROM careers WHERE name = 'career.shieldbreaker.name')),

    -- Scribe career entries
    ((SELECT id FROM careers WHERE name = 'career.scribe.name'), (SELECT id FROM careers WHERE name = 'career.apprentice_wizard.name')),
    ((SELECT id FROM careers WHERE name = 'career.scribe.name'), (SELECT id FROM careers WHERE name = 'career.initiate.name')),

    -- Seaman career entries
    ((SELECT id FROM careers WHERE name = 'career.seaman.name'), (SELECT id FROM careers WHERE name = 'career.boatman.name')),
    ((SELECT id FROM careers WHERE name = 'career.seaman.name'), (SELECT id FROM careers WHERE name = 'career.envoy.name')),
    ((SELECT id FROM careers WHERE name = 'career.seaman.name'), (SELECT id FROM careers WHERE name = 'career.ferryman.name')),
    ((SELECT id FROM careers WHERE name = 'career.seaman.name'), (SELECT id FROM careers WHERE name = 'career.fisherman.name')),
    ((SELECT id FROM careers WHERE name = 'career.seaman.name'), (SELECT id FROM careers WHERE name = 'career.norse_berserker.name')),
    ((SELECT id FROM careers WHERE name = 'career.seaman.name'), (SELECT id FROM careers WHERE name = 'career.smuggler.name')),

    -- Servant career entries
    ((SELECT id FROM careers WHERE name = 'career.servant.name'), (SELECT id FROM careers WHERE name = 'career.camp_follower.name')),
    ((SELECT id FROM careers WHERE name = 'career.servant.name'), (SELECT id FROM careers WHERE name = 'career.peasant.name')),
    ((SELECT id FROM careers WHERE name = 'career.servant.name'), (SELECT id FROM careers WHERE name = 'career.rogue.name')),

    -- Shieldbreaker career entries
    ((SELECT id FROM careers WHERE name = 'career.shieldbreaker.name'), (SELECT id FROM careers WHERE name = 'career.kislevite_kossar.name')),
    ((SELECT id FROM careers WHERE name = 'career.shieldbreaker.name'), (SELECT id FROM careers WHERE name = 'career.mercenary.name')),
    ((SELECT id FROM careers WHERE name = 'career.shieldbreaker.name'), (SELECT id FROM careers WHERE name = 'career.miner.name')),
    ((SELECT id FROM careers WHERE name = 'career.shieldbreaker.name'), (SELECT id FROM careers WHERE name = 'career.rat_catcher.name')),
    ((SELECT id FROM careers WHERE name = 'career.shieldbreaker.name'), (SELECT id FROM careers WHERE name = 'career.runebearer.name')),
    ((SELECT id FROM careers WHERE name = 'career.shieldbreaker.name'), (SELECT id FROM careers WHERE name = 'career.smuggler.name')),
    ((SELECT id FROM careers WHERE name = 'career.shieldbreaker.name'), (SELECT id FROM careers WHERE name = 'career.tomb_robber.name')),

    -- Smuggler career entries
    ((SELECT id FROM careers WHERE name = 'career.smuggler.name'), (SELECT id FROM careers WHERE name = 'career.bailiff.name')),
    ((SELECT id FROM careers WHERE name = 'career.smuggler.name'), (SELECT id FROM careers WHERE name = 'career.boatman.name')),
    ((SELECT id FROM careers WHERE name = 'career.smuggler.name'), (SELECT id FROM careers WHERE name = 'career.bone_picker.name')),
    ((SELECT id FROM careers WHERE name = 'career.smuggler.name'), (SELECT id FROM careers WHERE name = 'career.camp_follower.name')),
    ((SELECT id FROM careers WHERE name = 'career.smuggler.name'), (SELECT id FROM careers WHERE name = 'career.coachman.name')),
    ((SELECT id FROM careers WHERE name = 'career.smuggler.name'), (SELECT id FROM careers WHERE name = 'career.engineer.name')),
    ((SELECT id FROM careers WHERE name = 'career.smuggler.name'), (SELECT id FROM careers WHERE name = 'career.ferryman.name')),
    ((SELECT id FROM careers WHERE name = 'career.smuggler.name'), (SELECT id FROM careers WHERE name = 'career.inkeeper.name')),
    ((SELECT id FROM careers WHERE name = 'career.smuggler.name'), (SELECT id FROM careers WHERE name = 'career.marine.name')),
    ((SELECT id FROM careers WHERE name = 'career.smuggler.name'), (SELECT id FROM careers WHERE name = 'career.miner.name')),
    ((SELECT id FROM careers WHERE name = 'career.smuggler.name'), (SELECT id FROM careers WHERE name = 'career.seaman.name')),
    ((SELECT id FROM careers WHERE name = 'career.smuggler.name'), (SELECT id FROM careers WHERE name = 'career.shieldbreaker.name')),

    -- Soldier career entries
    ((SELECT id FROM careers WHERE name = 'career.soldier.name'), (SELECT id FROM careers WHERE name = 'career.flagellant.name')),
    ((SELECT id FROM careers WHERE name = 'career.soldier.name'), (SELECT id FROM careers WHERE name = 'career.hunter.name')),
    ((SELECT id FROM careers WHERE name = 'career.soldier.name'), (SELECT id FROM careers WHERE name = 'career.messenger.name')),
    ((SELECT id FROM careers WHERE name = 'career.soldier.name'), (SELECT id FROM careers WHERE name = 'career.toll_keeper.name')),
    ((SELECT id FROM careers WHERE name = 'career.soldier.name'), (SELECT id FROM careers WHERE name = 'career.watchman.name')),

    -- Squire career entries
    ((SELECT id FROM careers WHERE name = 'career.squire.name'), (SELECT id FROM careers WHERE name = 'career.herald.name')),
    ((SELECT id FROM careers WHERE name = 'career.squire.name'), (SELECT id FROM careers WHERE name = 'career.noble.name')),
    ((SELECT id FROM careers WHERE name = 'career.squire.name'), (SELECT id FROM careers WHERE name = 'career.valet.name')),

    -- Student career entries
    ((SELECT id FROM careers WHERE name = 'career.student.name'), (SELECT id FROM careers WHERE name = 'career.envoy.name')),
    ((SELECT id FROM careers WHERE name = 'career.student.name'), (SELECT id FROM careers WHERE name = 'career.grave_robber.name')),
    ((SELECT id FROM careers WHERE name = 'career.student.name'), (SELECT id FROM careers WHERE name = 'career.minstrel.name')),
    ((SELECT id FROM careers WHERE name = 'career.student.name'), (SELECT id FROM careers WHERE name = 'career.noble.name')),
    ((SELECT id FROM careers WHERE name = 'career.student.name'), (SELECT id FROM careers WHERE name = 'career.valet.name')),

    -- Thief career entries
    ((SELECT id FROM careers WHERE name = 'career.thief.name'), (SELECT id FROM careers WHERE name = 'career.entertainer.name')),
    ((SELECT id FROM careers WHERE name = 'career.thief.name'), (SELECT id FROM careers WHERE name = 'career.grave_robber.name')),
    ((SELECT id FROM careers WHERE name = 'career.thief.name'), (SELECT id FROM careers WHERE name = 'career.interrogator.name')),
    ((SELECT id FROM careers WHERE name = 'career.thief.name'), (SELECT id FROM careers WHERE name = 'career.militiaman.name')),
    ((SELECT id FROM careers WHERE name = 'career.thief.name'), (SELECT id FROM careers WHERE name = 'career.outlaw.name')),
    ((SELECT id FROM careers WHERE name = 'career.thief.name'), (SELECT id FROM careers WHERE name = 'career.protagonist.name')),
    ((SELECT id FROM careers WHERE name = 'career.thief.name'), (SELECT id FROM careers WHERE name = 'career.rat_catcher.name')),
    ((SELECT id FROM careers WHERE name = 'career.thief.name'), (SELECT id FROM careers WHERE name = 'career.rogue.name')),
    ((SELECT id FROM careers WHERE name = 'career.thief.name'), (SELECT id FROM careers WHERE name = 'career.servant.name')),
    ((SELECT id FROM careers WHERE name = 'career.thief.name'), (SELECT id FROM careers WHERE name = 'career.smuggler.name')),
    ((SELECT id FROM careers WHERE name = 'career.thief.name'), (SELECT id FROM careers WHERE name = 'career.toll_keeper.name')),
    ((SELECT id FROM careers WHERE name = 'career.thief.name'), (SELECT id FROM careers WHERE name = 'career.tomb_robber.name')),
    ((SELECT id FROM careers WHERE name = 'career.thief.name'), (SELECT id FROM careers WHERE name = 'career.vagabond.name')),

    -- Thug career entries
    ((SELECT id FROM careers WHERE name = 'career.thug.name'), (SELECT id FROM careers WHERE name = 'career.marine.name')),
    ((SELECT id FROM careers WHERE name = 'career.thug.name'), (SELECT id FROM careers WHERE name = 'career.protagonist.name')),

    -- Toll Keeper career entries
    ((SELECT id FROM careers WHERE name = 'career.toll_keeper.name'), (SELECT id FROM careers WHERE name = 'career.bailiff.name')),
    ((SELECT id FROM careers WHERE name = 'career.toll_keeper.name'), (SELECT id FROM careers WHERE name = 'career.coachman.name')),
    ((SELECT id FROM careers WHERE name = 'career.toll_keeper.name'), (SELECT id FROM careers WHERE name = 'career.roadwarden.name')),

    -- Tomb Robber career entries
    ((SELECT id FROM careers WHERE name = 'career.tomb_robber.name'), (SELECT id FROM careers WHERE name = 'career.runebearer.name')),
    ((SELECT id FROM careers WHERE name = 'career.tomb_robber.name'), (SELECT id FROM careers WHERE name = 'career.shieldbreaker.name')),
    ((SELECT id FROM careers WHERE name = 'career.tomb_robber.name'), (SELECT id FROM careers WHERE name = 'career.thief.name')),

    -- Tradesman career entries
    ((SELECT id FROM careers WHERE name = 'career.tradesman.name'), (SELECT id FROM careers WHERE name = 'career.barber_surgeon.name')),
    ((SELECT id FROM careers WHERE name = 'career.tradesman.name'), (SELECT id FROM careers WHERE name = 'career.burgher.name')),
    ((SELECT id FROM careers WHERE name = 'career.tradesman.name'), (SELECT id FROM careers WHERE name = 'career.camp_follower.name')),
    ((SELECT id FROM careers WHERE name = 'career.tradesman.name'), (SELECT id FROM careers WHERE name = 'career.peasant.name')),
    ((SELECT id FROM careers WHERE name = 'career.tradesman.name'), (SELECT id FROM careers WHERE name = 'career.watchman.name')),

    -- Troll Slayer career entries
    ((SELECT id FROM careers WHERE name = 'career.troll_slayer.name'), (SELECT id FROM careers WHERE name = 'career.pit_fighter.name')),

    -- Vagabond career entries
    ((SELECT id FROM careers WHERE name = 'career.vagabond.name'), (SELECT id FROM careers WHERE name = 'career.barber_surgeon.name')),
    ((SELECT id FROM careers WHERE name = 'career.vagabond.name'), (SELECT id FROM careers WHERE name = 'career.camp_follower.name')),
    ((SELECT id FROM careers WHERE name = 'career.vagabond.name'), (SELECT id FROM careers WHERE name = 'career.cat_burglar.name')),
    ((SELECT id FROM careers WHERE name = 'career.vagabond.name'), (SELECT id FROM careers WHERE name = 'career.charcoal_burner.name')),
    ((SELECT id FROM careers WHERE name = 'career.vagabond.name'), (SELECT id FROM careers WHERE name = 'career.entertainer.name')),
    ((SELECT id FROM careers WHERE name = 'career.vagabond.name'), (SELECT id FROM careers WHERE name = 'career.envoy.name')),
    ((SELECT id FROM careers WHERE name = 'career.vagabond.name'), (SELECT id FROM careers WHERE name = 'career.fieldwarden.name')),
    ((SELECT id FROM careers WHERE name = 'career.vagabond.name'), (SELECT id FROM careers WHERE name = 'career.hedge_wizard.name')),
    ((SELECT id FROM careers WHERE name = 'career.vagabond.name'), (SELECT id FROM careers WHERE name = 'career.kithband_warrior.name')),
    ((SELECT id FROM careers WHERE name = 'career.vagabond.name'), (SELECT id FROM careers WHERE name = 'career.outlaw.name')),
    ((SELECT id FROM careers WHERE name = 'career.vagabond.name'), (SELECT id FROM careers WHERE name = 'career.soldier.name')),
    ((SELECT id FROM careers WHERE name = 'career.vagabond.name'), (SELECT id FROM careers WHERE name = 'career.woodsman.name')),

    -- Valet career entries
    ((SELECT id FROM careers WHERE name = 'career.valet.name'), (SELECT id FROM careers WHERE name = 'career.burgher.name')),
    ((SELECT id FROM careers WHERE name = 'career.valet.name'), (SELECT id FROM careers WHERE name = 'career.servant.name')),

    -- Watchman career entries
    ((SELECT id FROM careers WHERE name = 'career.watchman.name'), (SELECT id FROM careers WHERE name = 'career.jailer.name')),
    ((SELECT id FROM careers WHERE name = 'career.watchman.name'), (SELECT id FROM careers WHERE name = 'career.soldier.name')),

    -- Woodsman career entries
    ((SELECT id FROM careers WHERE name = 'career.woodsman.name'), (SELECT id FROM careers WHERE name = 'career.charcoal_burner.name')),
    ((SELECT id FROM careers WHERE name = 'career.woodsman.name'), (SELECT id FROM careers WHERE name = 'career.vagabond.name')),

    -- Zealot career entries
    ((SELECT id FROM careers WHERE name = 'career.zealot.name'), (SELECT id FROM careers WHERE name = 'career.agitator.name')),
    ((SELECT id FROM careers WHERE name = 'career.zealot.name'), (SELECT id FROM careers WHERE name = 'career.initiate.name')),
    ((SELECT id FROM careers WHERE name = 'career.zealot.name'), (SELECT id FROM careers WHERE name = 'career.judicial_champion.name')),
    ((SELECT id FROM careers WHERE name = 'career.zealot.name'), (SELECT id FROM careers WHERE name = 'career.peasant.name')),
    ((SELECT id FROM careers WHERE name = 'career.zealot.name'), (SELECT id FROM careers WHERE name = 'career.tradesman.name')),

    -- Anointed Priest career entries
    ((SELECT id FROM careers WHERE name = 'career.anointed_priest.name'), (SELECT id FROM careers WHERE name = 'career.priest.name')),

    -- Artisan career entries
    ((SELECT id FROM careers WHERE name = 'career.artisan.name'), (SELECT id FROM careers WHERE name = 'career.engineer.name')),
    ((SELECT id FROM careers WHERE name = 'career.artisan.name'), (SELECT id FROM careers WHERE name = 'career.militiaman.name')),
    ((SELECT id FROM careers WHERE name = 'career.artisan.name'), (SELECT id FROM careers WHERE name = 'career.navigator.name')),
    ((SELECT id FROM careers WHERE name = 'career.artisan.name'), (SELECT id FROM careers WHERE name = 'career.tradesman.name')),

    -- Assassin career entries
    ((SELECT id FROM careers WHERE name = 'career.assassin.name'), (SELECT id FROM careers WHERE name = 'career.champion.name')),
    ((SELECT id FROM careers WHERE name = 'career.assassin.name'), (SELECT id FROM careers WHERE name = 'career.duellist.name')),
    ((SELECT id FROM careers WHERE name = 'career.assassin.name'), (SELECT id FROM careers WHERE name = 'career.judicial_champion.name')),
    ((SELECT id FROM careers WHERE name = 'career.assassin.name'), (SELECT id FROM careers WHERE name = 'career.outlaw_chief.name')),
    ((SELECT id FROM careers WHERE name = 'career.assassin.name'), (SELECT id FROM careers WHERE name = 'career.spy.name')),
    ((SELECT id FROM careers WHERE name = 'career.assassin.name'), (SELECT id FROM careers WHERE name = 'career.targeteer.name')),

    -- Captain career entries
    ((SELECT id FROM careers WHERE name = 'career.captain.name'), (SELECT id FROM careers WHERE name = 'career.explorer.name')),
    ((SELECT id FROM careers WHERE name = 'career.captain.name'), (SELECT id FROM careers WHERE name = 'career.ghost_strider.name')),
    ((SELECT id FROM careers WHERE name = 'career.captain.name'), (SELECT id FROM careers WHERE name = 'career.knight.name')),
    ((SELECT id FROM careers WHERE name = 'career.captain.name'), (SELECT id FROM careers WHERE name = 'career.knight_of_the_inner_circle.name')),
    ((SELECT id FROM careers WHERE name = 'career.captain.name'), (SELECT id FROM careers WHERE name = 'career.noble_lord.name')),
    ((SELECT id FROM careers WHERE name = 'career.captain.name'), (SELECT id FROM careers WHERE name = 'career.outlaw_chief.name')),
    ((SELECT id FROM careers WHERE name = 'career.captain.name'), (SELECT id FROM careers WHERE name = 'career.sergeant.name')),
    ((SELECT id FROM careers WHERE name = 'career.captain.name'), (SELECT id FROM careers WHERE name = 'career.witch_hunter.name')),

    -- Cat Burglar career entries
    ((SELECT id FROM careers WHERE name = 'career.cat_burglar.name'), (SELECT id FROM careers WHERE name = 'career.bone_picker.name')),
    ((SELECT id FROM careers WHERE name = 'career.cat_burglar.name'), (SELECT id FROM careers WHERE name = 'career.charlatan.name')),
    ((SELECT id FROM careers WHERE name = 'career.cat_burglar.name'), (SELECT id FROM careers WHERE name = 'career.grave_robber.name')),
    ((SELECT id FROM careers WHERE name = 'career.cat_burglar.name'), (SELECT id FROM careers WHERE name = 'career.rat_catcher.name')),
    ((SELECT id FROM careers WHERE name = 'career.cat_burglar.name'), (SELECT id FROM careers WHERE name = 'career.thief.name')),

    -- Champion career entries
    ((SELECT id FROM careers WHERE name = 'career.champion.name'), (SELECT id FROM careers WHERE name = 'career.assassin.name')),
    ((SELECT id FROM careers WHERE name = 'career.champion.name'), (SELECT id FROM careers WHERE name = 'career.duellist.name')),
    ((SELECT id FROM careers WHERE name = 'career.champion.name'), (SELECT id FROM careers WHERE name = 'career.judicial_champion.name')),
    ((SELECT id FROM careers WHERE name = 'career.champion.name'), (SELECT id FROM careers WHERE name = 'career.knight_of_the_inner_circle.name')),
    ((SELECT id FROM careers WHERE name = 'career.champion.name'), (SELECT id FROM careers WHERE name = 'career.targeteer.name')),
    ((SELECT id FROM careers WHERE name = 'career.champion.name'), (SELECT id FROM careers WHERE name = 'career.veteran.name')),
    ((SELECT id FROM careers WHERE name = 'career.champion.name'), (SELECT id FROM careers WHERE name = 'career.witch_hunter.name')),

    -- Charlatan career entries
    ((SELECT id FROM careers WHERE name = 'career.charlatan.name'), (SELECT id FROM careers WHERE name = 'career.agitator.name')),
    ((SELECT id FROM careers WHERE name = 'career.charlatan.name'), (SELECT id FROM careers WHERE name = 'career.camp_follower.name')),
    ((SELECT id FROM careers WHERE name = 'career.charlatan.name'), (SELECT id FROM careers WHERE name = 'career.courtier.name')),
    ((SELECT id FROM careers WHERE name = 'career.charlatan.name'), (SELECT id FROM careers WHERE name = 'career.entertainer.name')),
    ((SELECT id FROM careers WHERE name = 'career.charlatan.name'), (SELECT id FROM careers WHERE name = 'career.envoy.name')),
    ((SELECT id FROM careers WHERE name = 'career.charlatan.name'), (SELECT id FROM careers WHERE name = 'career.fence.name')),
    ((SELECT id FROM careers WHERE name = 'career.charlatan.name'), (SELECT id FROM careers WHERE name = 'career.hedge_wizard.name')),
    ((SELECT id FROM careers WHERE name = 'career.charlatan.name'), (SELECT id FROM careers WHERE name = 'career.journeyman_wizard.name')),
    ((SELECT id FROM careers WHERE name = 'career.charlatan.name'), (SELECT id FROM careers WHERE name = 'career.minstrel.name')),
    ((SELECT id FROM careers WHERE name = 'career.charlatan.name'), (SELECT id FROM careers WHERE name = 'career.rogue.name')),
    ((SELECT id FROM careers WHERE name = 'career.charlatan.name'), (SELECT id FROM careers WHERE name = 'career.smuggler.name')),
    ((SELECT id FROM careers WHERE name = 'career.charlatan.name'), (SELECT id FROM careers WHERE name = 'career.thief.name')),

    -- Courtier career entries
    ((SELECT id FROM careers WHERE name = 'career.courtier.name'), (SELECT id FROM careers WHERE name = 'career.noble.name')),
    ((SELECT id FROM careers WHERE name = 'career.courtier.name'), (SELECT id FROM careers WHERE name = 'career.herald.name')),
    ((SELECT id FROM careers WHERE name = 'career.courtier.name'), (SELECT id FROM careers WHERE name = 'career.pistolier.name')),
    ((SELECT id FROM careers WHERE name = 'career.courtier.name'), (SELECT id FROM careers WHERE name = 'career.politician.name')),

    -- Crime Lord career entries
    ((SELECT id FROM careers WHERE name = 'career.crime_lord.name'), (SELECT id FROM careers WHERE name = 'career.cat_burglar.name')),
    ((SELECT id FROM careers WHERE name = 'career.crime_lord.name'), (SELECT id FROM careers WHERE name = 'career.demagogue.name')),
    ((SELECT id FROM careers WHERE name = 'career.crime_lord.name'), (SELECT id FROM careers WHERE name = 'career.fence.name')),
    ((SELECT id FROM careers WHERE name = 'career.crime_lord.name'), (SELECT id FROM careers WHERE name = 'career.guild_master.name')),
    ((SELECT id FROM careers WHERE name = 'career.crime_lord.name'), (SELECT id FROM careers WHERE name = 'career.master_thief.name')),
    ((SELECT id FROM careers WHERE name = 'career.crime_lord.name'), (SELECT id FROM careers WHERE name = 'career.outlaw_chief.name')),
    ((SELECT id FROM careers WHERE name = 'career.crime_lord.name'), (SELECT id FROM careers WHERE name = 'career.politician.name')),
    ((SELECT id FROM careers WHERE name = 'career.crime_lord.name'), (SELECT id FROM careers WHERE name = 'career.steward.name')),

    -- Deamon Slayer career entries
    ((SELECT id FROM careers WHERE name = 'career.deamon_slayer.name'), (SELECT id FROM careers WHERE name = 'career.giant_slayer.name')),

    -- Demagogue career entries
    ((SELECT id FROM careers WHERE name = 'career.demagogue.name'), (SELECT id FROM careers WHERE name = 'career.agitator.name')),
    ((SELECT id FROM careers WHERE name = 'career.demagogue.name'), (SELECT id FROM careers WHERE name = 'career.anointed_priest.name')),
    ((SELECT id FROM careers WHERE name = 'career.demagogue.name'), (SELECT id FROM careers WHERE name = 'career.artisan.name')),
    ((SELECT id FROM careers WHERE name = 'career.demagogue.name'), (SELECT id FROM careers WHERE name = 'career.charlatan.name')),
    ((SELECT id FROM careers WHERE name = 'career.demagogue.name'), (SELECT id FROM careers WHERE name = 'career.crime_lord.name')),
    ((SELECT id FROM careers WHERE name = 'career.demagogue.name'), (SELECT id FROM careers WHERE name = 'career.flagellant.name')),
    ((SELECT id FROM careers WHERE name = 'career.demagogue.name'), (SELECT id FROM careers WHERE name = 'career.friar.name')),
    ((SELECT id FROM careers WHERE name = 'career.demagogue.name'), (SELECT id FROM careers WHERE name = 'career.initiate.name')),
    ((SELECT id FROM careers WHERE name = 'career.demagogue.name'), (SELECT id FROM careers WHERE name = 'career.minstrel.name')),
    ((SELECT id FROM careers WHERE name = 'career.demagogue.name'), (SELECT id FROM careers WHERE name = 'career.outlaw.name')),
    ((SELECT id FROM careers WHERE name = 'career.demagogue.name'), (SELECT id FROM careers WHERE name = 'career.outlaw_chief.name')),
    ((SELECT id FROM careers WHERE name = 'career.demagogue.name'), (SELECT id FROM careers WHERE name = 'career.politician.name')),
    ((SELECT id FROM careers WHERE name = 'career.demagogue.name'), (SELECT id FROM careers WHERE name = 'career.rogue.name')),
    ((SELECT id FROM careers WHERE name = 'career.demagogue.name'), (SELECT id FROM careers WHERE name = 'career.vampire_hunter.name')),
    ((SELECT id FROM careers WHERE name = 'career.demagogue.name'), (SELECT id FROM careers WHERE name = 'career.witch_hunter.name')),

    -- Duellist career entries
    ((SELECT id FROM careers WHERE name = 'career.duellist.name'), (SELECT id FROM careers WHERE name = 'career.courtier.name')),
    ((SELECT id FROM careers WHERE name = 'career.duellist.name'), (SELECT id FROM careers WHERE name = 'career.estalian_diestro.name')),
    ((SELECT id FROM careers WHERE name = 'career.duellist.name'), (SELECT id FROM careers WHERE name = 'career.highwayman.name')),
    ((SELECT id FROM careers WHERE name = 'career.duellist.name'), (SELECT id FROM careers WHERE name = 'career.pistolier.name')),
    ((SELECT id FROM careers WHERE name = 'career.duellist.name'), (SELECT id FROM careers WHERE name = 'career.protagonist.name')),
    ((SELECT id FROM careers WHERE name = 'career.duellist.name'), (SELECT id FROM careers WHERE name = 'career.sergeant.name')),
    ((SELECT id FROM careers WHERE name = 'career.duellist.name'), (SELECT id FROM careers WHERE name = 'career.targeteer.name')),

    -- Engineer career entries
    ((SELECT id FROM careers WHERE name = 'career.engineer.name'), (SELECT id FROM careers WHERE name = 'career.artisan.name')),
    ((SELECT id FROM careers WHERE name = 'career.engineer.name'), (SELECT id FROM careers WHERE name = 'career.miner.name')),
    ((SELECT id FROM careers WHERE name = 'career.engineer.name'), (SELECT id FROM careers WHERE name = 'career.student.name')),
    ((SELECT id FROM careers WHERE name = 'career.engineer.name'), (SELECT id FROM careers WHERE name = 'career.tradesman.name')),

    -- Explorer career entries
    ((SELECT id FROM careers WHERE name = 'career.explorer.name'), (SELECT id FROM careers WHERE name = 'career.captain.name')),
    ((SELECT id FROM careers WHERE name = 'career.explorer.name'), (SELECT id FROM careers WHERE name = 'career.engineer.name')),
    ((SELECT id FROM careers WHERE name = 'career.explorer.name'), (SELECT id FROM careers WHERE name = 'career.herald.name')),
    ((SELECT id FROM careers WHERE name = 'career.explorer.name'), (SELECT id FROM careers WHERE name = 'career.master_thief.name')),
    ((SELECT id FROM careers WHERE name = 'career.explorer.name'), (SELECT id FROM careers WHERE name = 'career.master_wizard.name')),
    ((SELECT id FROM careers WHERE name = 'career.explorer.name'), (SELECT id FROM careers WHERE name = 'career.mate.name')),
    ((SELECT id FROM careers WHERE name = 'career.explorer.name'), (SELECT id FROM careers WHERE name = 'career.navigator.name')),
    ((SELECT id FROM careers WHERE name = 'career.explorer.name'), (SELECT id FROM careers WHERE name = 'career.scholar.name')),
    ((SELECT id FROM careers WHERE name = 'career.explorer.name'), (SELECT id FROM careers WHERE name = 'career.scout.name')),
    ((SELECT id FROM careers WHERE name = 'career.explorer.name'), (SELECT id FROM careers WHERE name = 'career.sea_captain.name')),
    ((SELECT id FROM careers WHERE name = 'career.explorer.name'), (SELECT id FROM careers WHERE name = 'career.spy.name')),
    ((SELECT id FROM careers WHERE name = 'career.explorer.name'), (SELECT id FROM careers WHERE name = 'career.wizard_lord.name')),

    -- Fence career entries
    ((SELECT id FROM careers WHERE name = 'career.fence.name'), (SELECT id FROM careers WHERE name = 'career.bone_picker.name')),
    ((SELECT id FROM careers WHERE name = 'career.fence.name'), (SELECT id FROM careers WHERE name = 'career.burgher.name')),
    ((SELECT id FROM careers WHERE name = 'career.fence.name'), (SELECT id FROM careers WHERE name = 'career.cat_burglar.name')),
    ((SELECT id FROM careers WHERE name = 'career.fence.name'), (SELECT id FROM careers WHERE name = 'career.grave_robber.name')),
    ((SELECT id FROM careers WHERE name = 'career.fence.name'), (SELECT id FROM careers WHERE name = 'career.inkeeper.name')),
    ((SELECT id FROM careers WHERE name = 'career.fence.name'), (SELECT id FROM careers WHERE name = 'career.racketeer.name')),
    ((SELECT id FROM careers WHERE name = 'career.fence.name'), (SELECT id FROM careers WHERE name = 'career.smuggler.name')),
    ((SELECT id FROM careers WHERE name = 'career.fence.name'), (SELECT id FROM careers WHERE name = 'career.steward.name')),
    ((SELECT id FROM careers WHERE name = 'career.fence.name'), (SELECT id FROM careers WHERE name = 'career.thief.name')),
    ((SELECT id FROM careers WHERE name = 'career.fence.name'), (SELECT id FROM careers WHERE name = 'career.tomb_robber.name')),

    -- Flagellant career entries
    ((SELECT id FROM careers WHERE name = 'career.flagellant.name'), (SELECT id FROM careers WHERE name = 'career.anointed_priest.name')),
    ((SELECT id FROM careers WHERE name = 'career.flagellant.name'), (SELECT id FROM careers WHERE name = 'career.friar.name')),
    ((SELECT id FROM careers WHERE name = 'career.flagellant.name'), (SELECT id FROM careers WHERE name = 'career.priest.name')),
    ((SELECT id FROM careers WHERE name = 'career.flagellant.name'), (SELECT id FROM careers WHERE name = 'career.zealot.name')),

    -- Friar career entries
    ((SELECT id FROM careers WHERE name = 'career.friar.name'), (SELECT id FROM careers WHERE name = 'career.demagogue.name')),
    ((SELECT id FROM careers WHERE name = 'career.friar.name'), (SELECT id FROM careers WHERE name = 'career.initiate.name')),
    ((SELECT id FROM careers WHERE name = 'career.friar.name'), (SELECT id FROM careers WHERE name = 'career.physician.name')),
    ((SELECT id FROM careers WHERE name = 'career.friar.name'), (SELECT id FROM careers WHERE name = 'career.scholar.name')),
    ((SELECT id FROM careers WHERE name = 'career.friar.name'), (SELECT id FROM careers WHERE name = 'career.vagabond.name')),
    ((SELECT id FROM careers WHERE name = 'career.friar.name'), (SELECT id FROM careers WHERE name = 'career.zealot.name')),

    -- Ghost Strider career entries
    ((SELECT id FROM careers WHERE name = 'career.ghost_strider.name'), (SELECT id FROM careers WHERE name = 'career.scout.name')),

    -- Giant Slayer career entries
    ((SELECT id FROM careers WHERE name = 'career.giant_slayer.name'), (SELECT id FROM careers WHERE name = 'career.troll_slayer.name')),

    -- Glorious Death career entries
    ((SELECT id FROM careers WHERE name = 'career.glorious_death.name'), (SELECT id FROM careers WHERE name = 'career.deamon_slayer.name')),

    -- Guild Master career entries
    ((SELECT id FROM careers WHERE name = 'career.guild_master.name'), (SELECT id FROM careers WHERE name = 'career.artisan.name')),
    ((SELECT id FROM careers WHERE name = 'career.guild_master.name'), (SELECT id FROM careers WHERE name = 'career.engineer.name')),
    ((SELECT id FROM careers WHERE name = 'career.guild_master.name'), (SELECT id FROM careers WHERE name = 'career.merchant.name')),
    ((SELECT id FROM careers WHERE name = 'career.guild_master.name'), (SELECT id FROM careers WHERE name = 'career.physician.name')),
    ((SELECT id FROM careers WHERE name = 'career.guild_master.name'), (SELECT id FROM careers WHERE name = 'career.wizard_lord.name')),

    -- Herald career entries
    ((SELECT id FROM careers WHERE name = 'career.herald.name'), (SELECT id FROM careers WHERE name = 'career.messenger.name')),
    ((SELECT id FROM careers WHERE name = 'career.herald.name'), (SELECT id FROM careers WHERE name = 'career.valet.name')),

    -- High Priest career entries
    ((SELECT id FROM careers WHERE name = 'career.high_priest.name'), (SELECT id FROM careers WHERE name = 'career.anointed_priest.name')),

    -- Highwayman career entries
    ((SELECT id FROM careers WHERE name = 'career.highwayman.name'), (SELECT id FROM careers WHERE name = 'career.coachman.name')),
    ((SELECT id FROM careers WHERE name = 'career.highwayman.name'), (SELECT id FROM careers WHERE name = 'career.duellist.name')),
    ((SELECT id FROM careers WHERE name = 'career.highwayman.name'), (SELECT id FROM careers WHERE name = 'career.estalian_diestro.name')),
    ((SELECT id FROM careers WHERE name = 'career.highwayman.name'), (SELECT id FROM careers WHERE name = 'career.ferryman.name')),
    ((SELECT id FROM careers WHERE name = 'career.highwayman.name'), (SELECT id FROM careers WHERE name = 'career.minstrel.name')),
    ((SELECT id FROM careers WHERE name = 'career.highwayman.name'), (SELECT id FROM careers WHERE name = 'career.outlaw.name')),
    ((SELECT id FROM careers WHERE name = 'career.highwayman.name'), (SELECT id FROM careers WHERE name = 'career.outrider.name')),
    ((SELECT id FROM careers WHERE name = 'career.highwayman.name'), (SELECT id FROM careers WHERE name = 'career.roadwarden.name')),
    ((SELECT id FROM careers WHERE name = 'career.highwayman.name'), (SELECT id FROM careers WHERE name = 'career.toll_keeper.name')),

    -- Inkeeper career entries
    ((SELECT id FROM careers WHERE name = 'career.inkeeper.name'), (SELECT id FROM careers WHERE name = 'career.burgher.name')),
    ((SELECT id FROM careers WHERE name = 'career.inkeeper.name'), (SELECT id FROM careers WHERE name = 'career.servant.name')),

    -- Interrogator career entries
    ((SELECT id FROM careers WHERE name = 'career.interrogator.name'), (SELECT id FROM careers WHERE name = 'career.barber_surgeon.name')),
    ((SELECT id FROM careers WHERE name = 'career.interrogator.name'), (SELECT id FROM careers WHERE name = 'career.bodyguard.name')),
    ((SELECT id FROM careers WHERE name = 'career.interrogator.name'), (SELECT id FROM careers WHERE name = 'career.flagellant.name')),
    ((SELECT id FROM careers WHERE name = 'career.interrogator.name'), (SELECT id FROM careers WHERE name = 'career.jailer.name')),
    ((SELECT id FROM careers WHERE name = 'career.interrogator.name'), (SELECT id FROM careers WHERE name = 'career.thug.name')),

    -- Journeyman Wizard career entries
    ((SELECT id FROM careers WHERE name = 'career.journeyman_wizard.name'), (SELECT id FROM careers WHERE name = 'career.apprentice_wizard.name')),

    -- Judicial Champion career entries
    ((SELECT id FROM careers WHERE name = 'career.judicial_champion.name'), (SELECT id FROM careers WHERE name = 'career.sergeant.name')),
    ((SELECT id FROM careers WHERE name = 'career.judicial_champion.name'), (SELECT id FROM careers WHERE name = 'career.veteran.name')),

    -- Knight career entries
    ((SELECT id FROM careers WHERE name = 'career.knight.name'), (SELECT id FROM careers WHERE name = 'career.noble_lord.name')),
    ((SELECT id FROM careers WHERE name = 'career.knight.name'), (SELECT id FROM careers WHERE name = 'career.pistolier.name')),
    ((SELECT id FROM careers WHERE name = 'career.knight.name'), (SELECT id FROM careers WHERE name = 'career.sergeant.name')),
    ((SELECT id FROM careers WHERE name = 'career.knight.name'), (SELECT id FROM careers WHERE name = 'career.squire.name')),
    ((SELECT id FROM careers WHERE name = 'career.knight.name'), (SELECT id FROM careers WHERE name = 'career.vampire_hunter.name')),

    -- Knight of the Inner Circle career entries
    ((SELECT id FROM careers WHERE name = 'career.knight_of_the_inner_circle.name'), (SELECT id FROM careers WHERE name = 'career.knight.name')),
    ((SELECT id FROM careers WHERE name = 'career.knight_of_the_inner_circle.name'), (SELECT id FROM careers WHERE name = 'career.witch_hunter.name')),

    -- Master Thief career entries
    ((SELECT id FROM careers WHERE name = 'career.master_thief.name'), (SELECT id FROM careers WHERE name = 'career.cat_burglar.name')),
    ((SELECT id FROM careers WHERE name = 'career.master_thief.name'), (SELECT id FROM careers WHERE name = 'career.crime_lord.name')),
    ((SELECT id FROM careers WHERE name = 'career.master_thief.name'), (SELECT id FROM careers WHERE name = 'career.fence.name')),
    ((SELECT id FROM careers WHERE name = 'career.master_thief.name'), (SELECT id FROM careers WHERE name = 'career.highwayman.name')),
    ((SELECT id FROM careers WHERE name = 'career.master_thief.name'), (SELECT id FROM careers WHERE name = 'career.racketeer.name')),
    ((SELECT id FROM careers WHERE name = 'career.master_thief.name'), (SELECT id FROM careers WHERE name = 'career.spy.name')),

    -- Master Wizard career entries
    ((SELECT id FROM careers WHERE name = 'career.master_wizard.name'), (SELECT id FROM careers WHERE name = 'career.journeyman_wizard.name')),

    -- Mate career entries
    ((SELECT id FROM careers WHERE name = 'career.mate.name'), (SELECT id FROM careers WHERE name = 'career.marine.name')),
    ((SELECT id FROM careers WHERE name = 'career.mate.name'), (SELECT id FROM careers WHERE name = 'career.seaman.name')),

    -- Merchant career entries
    ((SELECT id FROM careers WHERE name = 'career.merchant.name'), (SELECT id FROM careers WHERE name = 'career.artisan.name')),
    ((SELECT id FROM careers WHERE name = 'career.merchant.name'), (SELECT id FROM careers WHERE name = 'career.burgher.name')),
    ((SELECT id FROM careers WHERE name = 'career.merchant.name'), (SELECT id FROM careers WHERE name = 'career.captain.name')),
    ((SELECT id FROM careers WHERE name = 'career.merchant.name'), (SELECT id FROM careers WHERE name = 'career.envoy.name')),
    ((SELECT id FROM careers WHERE name = 'career.merchant.name'), (SELECT id FROM careers WHERE name = 'career.explorer.name')),
    ((SELECT id FROM careers WHERE name = 'career.merchant.name'), (SELECT id FROM careers WHERE name = 'career.fisherman.name')),
    ((SELECT id FROM careers WHERE name = 'career.merchant.name'), (SELECT id FROM careers WHERE name = 'career.inkeeper.name')),
    ((SELECT id FROM careers WHERE name = 'career.merchant.name'), (SELECT id FROM careers WHERE name = 'career.mate.name')),
    ((SELECT id FROM careers WHERE name = 'career.merchant.name'), (SELECT id FROM careers WHERE name = 'career.scholar.name')),
    ((SELECT id FROM careers WHERE name = 'career.merchant.name'), (SELECT id FROM careers WHERE name = 'career.steward.name')),
    ((SELECT id FROM careers WHERE name = 'career.merchant.name'), (SELECT id FROM careers WHERE name = 'career.tradesman.name')),

    -- Minstrel career entries
    ((SELECT id FROM careers WHERE name = 'career.minstrel.name'), (SELECT id FROM careers WHERE name = 'career.entertainer.name')),

    -- Navigator career entries
    ((SELECT id FROM careers WHERE name = 'career.navigator.name'), (SELECT id FROM careers WHERE name = 'career.boatman.name')),
    ((SELECT id FROM careers WHERE name = 'career.navigator.name'), (SELECT id FROM careers WHERE name = 'career.fisherman.name')),
    ((SELECT id FROM careers WHERE name = 'career.navigator.name'), (SELECT id FROM careers WHERE name = 'career.mate.name')),
    ((SELECT id FROM careers WHERE name = 'career.navigator.name'), (SELECT id FROM careers WHERE name = 'career.scribe.name')),
    ((SELECT id FROM careers WHERE name = 'career.navigator.name'), (SELECT id FROM careers WHERE name = 'career.seaman.name')),

    -- Noble Lord career entries
    ((SELECT id FROM careers WHERE name = 'career.noble_lord.name'), (SELECT id FROM careers WHERE name = 'career.courtier.name')),
    ((SELECT id FROM careers WHERE name = 'career.noble_lord.name'), (SELECT id FROM careers WHERE name = 'career.knight.name')),
    ((SELECT id FROM careers WHERE name = 'career.noble_lord.name'), (SELECT id FROM careers WHERE name = 'career.knight_of_the_inner_circle.name')),
    ((SELECT id FROM careers WHERE name = 'career.noble_lord.name'), (SELECT id FROM careers WHERE name = 'career.politician.name')),
    ((SELECT id FROM careers WHERE name = 'career.noble_lord.name'), (SELECT id FROM careers WHERE name = 'career.sea_captain.name')),

    -- Outlaw Chief career entries
    ((SELECT id FROM careers WHERE name = 'career.outlaw_chief.name'), (SELECT id FROM careers WHERE name = 'career.crime_lord.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw_chief.name'), (SELECT id FROM careers WHERE name = 'career.demagogue.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw_chief.name'), (SELECT id FROM careers WHERE name = 'career.ghost_strider.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw_chief.name'), (SELECT id FROM careers WHERE name = 'career.highwayman.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw_chief.name'), (SELECT id FROM careers WHERE name = 'career.master_thief.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw_chief.name'), (SELECT id FROM careers WHERE name = 'career.racketeer.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw_chief.name'), (SELECT id FROM careers WHERE name = 'career.scout.name')),
    ((SELECT id FROM careers WHERE name = 'career.outlaw_chief.name'), (SELECT id FROM careers WHERE name = 'career.veteran.name')),

    -- Physician career entries
    ((SELECT id FROM careers WHERE name = 'career.physician.name'), (SELECT id FROM careers WHERE name = 'career.barber_surgeon.name')),
    ((SELECT id FROM careers WHERE name = 'career.physician.name'), (SELECT id FROM careers WHERE name = 'career.interrogator.name')),
    ((SELECT id FROM careers WHERE name = 'career.physician.name'), (SELECT id FROM careers WHERE name = 'career.scholar.name')),
    ((SELECT id FROM careers WHERE name = 'career.physician.name'), (SELECT id FROM careers WHERE name = 'career.student.name')),

    -- Pistolier career entries
    ((SELECT id FROM careers WHERE name = 'career.pistolier.name'), (SELECT id FROM careers WHERE name = 'career.engineer.name')),
    ((SELECT id FROM careers WHERE name = 'career.pistolier.name'), (SELECT id FROM careers WHERE name = 'career.noble.name')),

    -- Politician career entries
    ((SELECT id FROM careers WHERE name = 'career.politician.name'), (SELECT id FROM careers WHERE name = 'career.agitator.name')),
    ((SELECT id FROM careers WHERE name = 'career.politician.name'), (SELECT id FROM careers WHERE name = 'career.bailiff.name')),
    ((SELECT id FROM careers WHERE name = 'career.politician.name'), (SELECT id FROM careers WHERE name = 'career.captain.name')),
    ((SELECT id FROM careers WHERE name = 'career.politician.name'), (SELECT id FROM careers WHERE name = 'career.charlatan.name')),
    ((SELECT id FROM careers WHERE name = 'career.politician.name'), (SELECT id FROM careers WHERE name = 'career.courtier.name')),
    ((SELECT id FROM careers WHERE name = 'career.politician.name'), (SELECT id FROM careers WHERE name = 'career.crime_lord.name')),
    ((SELECT id FROM careers WHERE name = 'career.politician.name'), (SELECT id FROM careers WHERE name = 'career.demagogue.name')),
    ((SELECT id FROM careers WHERE name = 'career.politician.name'), (SELECT id FROM careers WHERE name = 'career.guild_master.name')),
    ((SELECT id FROM careers WHERE name = 'career.politician.name'), (SELECT id FROM careers WHERE name = 'career.herald.name')),
    ((SELECT id FROM careers WHERE name = 'career.politician.name'), (SELECT id FROM careers WHERE name = 'career.high_priest.name')),
    ((SELECT id FROM careers WHERE name = 'career.politician.name'), (SELECT id FROM careers WHERE name = 'career.merchant.name')),
    ((SELECT id FROM careers WHERE name = 'career.politician.name'), (SELECT id FROM careers WHERE name = 'career.noble.name')),
    ((SELECT id FROM careers WHERE name = 'career.politician.name'), (SELECT id FROM careers WHERE name = 'career.peasant.name')),
    ((SELECT id FROM careers WHERE name = 'career.politician.name'), (SELECT id FROM careers WHERE name = 'career.racketeer.name')),
    ((SELECT id FROM careers WHERE name = 'career.politician.name'), (SELECT id FROM careers WHERE name = 'career.toll_keeper.name')),

    -- Priest career entries
    ((SELECT id FROM careers WHERE name = 'career.priest.name'), (SELECT id FROM careers WHERE name = 'career.flagellant.name')),
    ((SELECT id FROM careers WHERE name = 'career.priest.name'), (SELECT id FROM careers WHERE name = 'career.friar.name')),
    ((SELECT id FROM careers WHERE name = 'career.priest.name'), (SELECT id FROM careers WHERE name = 'career.initiate.name')),

    -- Racketeer career entries
    ((SELECT id FROM careers WHERE name = 'career.racketeer.name'), (SELECT id FROM careers WHERE name = 'career.bailiff.name')),
    ((SELECT id FROM careers WHERE name = 'career.racketeer.name'), (SELECT id FROM careers WHERE name = 'career.bodyguard.name')),
    ((SELECT id FROM careers WHERE name = 'career.racketeer.name'), (SELECT id FROM careers WHERE name = 'career.cat_burglar.name')),
    ((SELECT id FROM careers WHERE name = 'career.racketeer.name'), (SELECT id FROM careers WHERE name = 'career.fence.name')),
    ((SELECT id FROM careers WHERE name = 'career.racketeer.name'), (SELECT id FROM careers WHERE name = 'career.guild_master.name')),
    ((SELECT id FROM careers WHERE name = 'career.racketeer.name'), (SELECT id FROM careers WHERE name = 'career.interrogator.name')),
    ((SELECT id FROM careers WHERE name = 'career.racketeer.name'), (SELECT id FROM careers WHERE name = 'career.merchant.name')),
    ((SELECT id FROM careers WHERE name = 'career.racketeer.name'), (SELECT id FROM careers WHERE name = 'career.politician.name')),
    ((SELECT id FROM careers WHERE name = 'career.racketeer.name'), (SELECT id FROM careers WHERE name = 'career.protagonist.name')),
    ((SELECT id FROM careers WHERE name = 'career.racketeer.name'), (SELECT id FROM careers WHERE name = 'career.spy.name')),
    ((SELECT id FROM careers WHERE name = 'career.racketeer.name'), (SELECT id FROM careers WHERE name = 'career.thug.name')),

    -- Scholar career entries
    ((SELECT id FROM careers WHERE name = 'career.scholar.name'), (SELECT id FROM careers WHERE name = 'career.anointed_priest.name')),
    ((SELECT id FROM careers WHERE name = 'career.scholar.name'), (SELECT id FROM careers WHERE name = 'career.apprentice_wizard.name')),
    ((SELECT id FROM careers WHERE name = 'career.scholar.name'), (SELECT id FROM careers WHERE name = 'career.friar.name')),
    ((SELECT id FROM careers WHERE name = 'career.scholar.name'), (SELECT id FROM careers WHERE name = 'career.high_priest.name')),
    ((SELECT id FROM careers WHERE name = 'career.scholar.name'), (SELECT id FROM careers WHERE name = 'career.journeyman_wizard.name')),
    ((SELECT id FROM careers WHERE name = 'career.scholar.name'), (SELECT id FROM careers WHERE name = 'career.master_wizard.name')),
    ((SELECT id FROM careers WHERE name = 'career.scholar.name'), (SELECT id FROM careers WHERE name = 'career.navigator.name')),
    ((SELECT id FROM careers WHERE name = 'career.scholar.name'), (SELECT id FROM careers WHERE name = 'career.noble_lord.name')),
    ((SELECT id FROM careers WHERE name = 'career.scholar.name'), (SELECT id FROM careers WHERE name = 'career.physician.name')),
    ((SELECT id FROM careers WHERE name = 'career.scholar.name'), (SELECT id FROM careers WHERE name = 'career.priest.name')),
    ((SELECT id FROM careers WHERE name = 'career.scholar.name'), (SELECT id FROM careers WHERE name = 'career.scribe.name')),
    ((SELECT id FROM careers WHERE name = 'career.scholar.name'), (SELECT id FROM careers WHERE name = 'career.sea_captain.name')),
    ((SELECT id FROM careers WHERE name = 'career.scholar.name'), (SELECT id FROM careers WHERE name = 'career.student.name')),

    -- Scout career entries
    ((SELECT id FROM careers WHERE name = 'career.scout.name'), (SELECT id FROM careers WHERE name = 'career.bounty_hunter.name')),
    ((SELECT id FROM careers WHERE name = 'career.scout.name'), (SELECT id FROM careers WHERE name = 'career.champion.name')),
    ((SELECT id FROM careers WHERE name = 'career.scout.name'), (SELECT id FROM careers WHERE name = 'career.charcoal_burner.name')),
    ((SELECT id FROM careers WHERE name = 'career.scout.name'), (SELECT id FROM careers WHERE name = 'career.coachman.name')),
    ((SELECT id FROM careers WHERE name = 'career.scout.name'), (SELECT id FROM careers WHERE name = 'career.fieldwarden.name')),
    ((SELECT id FROM careers WHERE name = 'career.scout.name'), (SELECT id FROM careers WHERE name = 'career.hunter.name')),
    ((SELECT id FROM careers WHERE name = 'career.scout.name'), (SELECT id FROM careers WHERE name = 'career.kithband_warrior.name')),
    ((SELECT id FROM careers WHERE name = 'career.scout.name'), (SELECT id FROM careers WHERE name = 'career.messenger.name')),
    ((SELECT id FROM careers WHERE name = 'career.scout.name'), (SELECT id FROM careers WHERE name = 'career.miner.name')),
    ((SELECT id FROM careers WHERE name = 'career.scout.name'), (SELECT id FROM careers WHERE name = 'career.outrider.name')),
    ((SELECT id FROM careers WHERE name = 'career.scout.name'), (SELECT id FROM careers WHERE name = 'career.roadwarden.name')),
    ((SELECT id FROM careers WHERE name = 'career.scout.name'), (SELECT id FROM careers WHERE name = 'career.runebearer.name')),
    ((SELECT id FROM careers WHERE name = 'career.scout.name'), (SELECT id FROM careers WHERE name = 'career.vagabond.name')),
    ((SELECT id FROM careers WHERE name = 'career.scout.name'), (SELECT id FROM careers WHERE name = 'career.woodsman.name')),

    -- Sea Captain career entries
    ((SELECT id FROM careers WHERE name = 'career.sea_captain.name'), (SELECT id FROM careers WHERE name = 'career.explorer.name')),
    ((SELECT id FROM careers WHERE name = 'career.sea_captain.name'), (SELECT id FROM careers WHERE name = 'career.mate.name')),
    ((SELECT id FROM careers WHERE name = 'career.sea_captain.name'), (SELECT id FROM careers WHERE name = 'career.navigator.name')),
    ((SELECT id FROM careers WHERE name = 'career.sea_captain.name'), (SELECT id FROM careers WHERE name = 'career.noble_lord.name')),

    -- Sergeant career entries
    ((SELECT id FROM careers WHERE name = 'career.sergeant.name'), (SELECT id FROM careers WHERE name = 'career.assassin.name')),
    ((SELECT id FROM careers WHERE name = 'career.sergeant.name'), (SELECT id FROM careers WHERE name = 'career.champion.name')),
    ((SELECT id FROM careers WHERE name = 'career.sergeant.name'), (SELECT id FROM careers WHERE name = 'career.duellist.name')),
    ((SELECT id FROM careers WHERE name = 'career.sergeant.name'), (SELECT id FROM careers WHERE name = 'career.highwayman.name')),
    ((SELECT id FROM careers WHERE name = 'career.sergeant.name'), (SELECT id FROM careers WHERE name = 'career.judicial_champion.name')),
    ((SELECT id FROM careers WHERE name = 'career.sergeant.name'), (SELECT id FROM careers WHERE name = 'career.kislevite_kossar.name')),
    ((SELECT id FROM careers WHERE name = 'career.sergeant.name'), (SELECT id FROM careers WHERE name = 'career.marine.name')),
    ((SELECT id FROM careers WHERE name = 'career.sergeant.name'), (SELECT id FROM careers WHERE name = 'career.mercenary.name')),
    ((SELECT id FROM careers WHERE name = 'career.sergeant.name'), (SELECT id FROM careers WHERE name = 'career.militiaman.name')),
    ((SELECT id FROM careers WHERE name = 'career.sergeant.name'), (SELECT id FROM careers WHERE name = 'career.norse_berserker.name')),
    ((SELECT id FROM careers WHERE name = 'career.sergeant.name'), (SELECT id FROM careers WHERE name = 'career.soldier.name')),
    ((SELECT id FROM careers WHERE name = 'career.sergeant.name'), (SELECT id FROM careers WHERE name = 'career.squire.name')),
    ((SELECT id FROM careers WHERE name = 'career.sergeant.name'), (SELECT id FROM careers WHERE name = 'career.targeteer.name')),
    ((SELECT id FROM careers WHERE name = 'career.sergeant.name'), (SELECT id FROM careers WHERE name = 'career.veteran.name')),
    ((SELECT id FROM careers WHERE name = 'career.sergeant.name'), (SELECT id FROM careers WHERE name = 'career.watchman.name')),

    -- Spy career entries
    ((SELECT id FROM careers WHERE name = 'career.spy.name'), (SELECT id FROM careers WHERE name = 'career.camp_follower.name')),
    ((SELECT id FROM careers WHERE name = 'career.spy.name'), (SELECT id FROM careers WHERE name = 'career.charlatan.name')),
    ((SELECT id FROM careers WHERE name = 'career.spy.name'), (SELECT id FROM careers WHERE name = 'career.courtier.name')),
    ((SELECT id FROM careers WHERE name = 'career.spy.name'), (SELECT id FROM careers WHERE name = 'career.explorer.name')),
    ((SELECT id FROM careers WHERE name = 'career.spy.name'), (SELECT id FROM careers WHERE name = 'career.merchant.name')),
    ((SELECT id FROM careers WHERE name = 'career.spy.name'), (SELECT id FROM careers WHERE name = 'career.minstrel.name')),
    ((SELECT id FROM careers WHERE name = 'career.spy.name'), (SELECT id FROM careers WHERE name = 'career.physician.name')),
    ((SELECT id FROM careers WHERE name = 'career.spy.name'), (SELECT id FROM careers WHERE name = 'career.sea_captain.name')),
    ((SELECT id FROM careers WHERE name = 'career.spy.name'), (SELECT id FROM careers WHERE name = 'career.servant.name')),

    -- Steward career entries
    ((SELECT id FROM careers WHERE name = 'career.steward.name'), (SELECT id FROM careers WHERE name = 'career.courtier.name')),
    ((SELECT id FROM careers WHERE name = 'career.steward.name'), (SELECT id FROM careers WHERE name = 'career.politician.name')),
    ((SELECT id FROM careers WHERE name = 'career.steward.name'), (SELECT id FROM careers WHERE name = 'career.priest.name')),
    ((SELECT id FROM careers WHERE name = 'career.steward.name'), (SELECT id FROM careers WHERE name = 'career.scholar.name')),
    ((SELECT id FROM careers WHERE name = 'career.steward.name'), (SELECT id FROM careers WHERE name = 'career.valet.name')),

    -- Targeteer career entries
    ((SELECT id FROM careers WHERE name = 'career.targeteer.name'), (SELECT id FROM careers WHERE name = 'career.bounty_hunter.name')),
    ((SELECT id FROM careers WHERE name = 'career.targeteer.name'), (SELECT id FROM careers WHERE name = 'career.ghost_strider.name')),
    ((SELECT id FROM careers WHERE name = 'career.targeteer.name'), (SELECT id FROM careers WHERE name = 'career.master_thief.name')),
    ((SELECT id FROM careers WHERE name = 'career.targeteer.name'), (SELECT id FROM careers WHERE name = 'career.vampire_hunter.name')),
    ((SELECT id FROM careers WHERE name = 'career.targeteer.name'), (SELECT id FROM careers WHERE name = 'career.veteran.name')),

    -- Vampire Hunter career entries
    ((SELECT id FROM careers WHERE name = 'career.vampire_hunter.name'), (SELECT id FROM careers WHERE name = 'career.bounty_hunter.name')),
    ((SELECT id FROM careers WHERE name = 'career.vampire_hunter.name'), (SELECT id FROM careers WHERE name = 'career.fieldwarden.name')),
    ((SELECT id FROM careers WHERE name = 'career.vampire_hunter.name'), (SELECT id FROM careers WHERE name = 'career.ghost_strider.name')),
    ((SELECT id FROM careers WHERE name = 'career.vampire_hunter.name'), (SELECT id FROM careers WHERE name = 'career.knight.name')),
    ((SELECT id FROM careers WHERE name = 'career.vampire_hunter.name'), (SELECT id FROM careers WHERE name = 'career.scout.name')),
    ((SELECT id FROM careers WHERE name = 'career.vampire_hunter.name'), (SELECT id FROM careers WHERE name = 'career.tomb_robber.name')),

    -- Veteran career entries
    ((SELECT id FROM careers WHERE name = 'career.veteran.name'), (SELECT id FROM careers WHERE name = 'career.flagellant.name')),
    ((SELECT id FROM careers WHERE name = 'career.veteran.name'), (SELECT id FROM careers WHERE name = 'career.kislevite_kossar.name')),
    ((SELECT id FROM careers WHERE name = 'career.veteran.name'), (SELECT id FROM careers WHERE name = 'career.kithband_warrior.name')),
    ((SELECT id FROM careers WHERE name = 'career.veteran.name'), (SELECT id FROM careers WHERE name = 'career.mercenary.name')),
    ((SELECT id FROM careers WHERE name = 'career.veteran.name'), (SELECT id FROM careers WHERE name = 'career.norse_berserker.name')),
    ((SELECT id FROM careers WHERE name = 'career.veteran.name'), (SELECT id FROM careers WHERE name = 'career.outlaw.name')),
    ((SELECT id FROM careers WHERE name = 'career.veteran.name'), (SELECT id FROM careers WHERE name = 'career.pistolier.name')),
    ((SELECT id FROM careers WHERE name = 'career.veteran.name'), (SELECT id FROM careers WHERE name = 'career.pit_fighter.name')),
    ((SELECT id FROM careers WHERE name = 'career.veteran.name'), (SELECT id FROM careers WHERE name = 'career.runebearer.name')),
    ((SELECT id FROM careers WHERE name = 'career.veteran.name'), (SELECT id FROM careers WHERE name = 'career.shieldbreaker.name')),
    ((SELECT id FROM careers WHERE name = 'career.veteran.name'), (SELECT id FROM careers WHERE name = 'career.soldier.name')),
    ((SELECT id FROM careers WHERE name = 'career.veteran.name'), (SELECT id FROM careers WHERE name = 'career.squire.name')),

    -- Witch Hunter career entries
    ((SELECT id FROM careers WHERE name = 'career.witch_hunter.name'), (SELECT id FROM careers WHERE name = 'career.anointed_priest.name')),
    ((SELECT id FROM careers WHERE name = 'career.witch_hunter.name'), (SELECT id FROM careers WHERE name = 'career.assassin.name')),
    ((SELECT id FROM careers WHERE name = 'career.witch_hunter.name'), (SELECT id FROM careers WHERE name = 'career.champion.name')),
    ((SELECT id FROM careers WHERE name = 'career.witch_hunter.name'), (SELECT id FROM careers WHERE name = 'career.high_priest.name')),
    ((SELECT id FROM careers WHERE name = 'career.witch_hunter.name'), (SELECT id FROM careers WHERE name = 'career.judicial_champion.name')),
    ((SELECT id FROM careers WHERE name = 'career.witch_hunter.name'), (SELECT id FROM careers WHERE name = 'career.knight_of_the_inner_circle.name')),
    ((SELECT id FROM careers WHERE name = 'career.witch_hunter.name'), (SELECT id FROM careers WHERE name = 'career.vampire_hunter.name')),

    -- Wizard Lord career entries
    ((SELECT id FROM careers WHERE name = 'career.wizard_lord.name'), (SELECT id FROM careers WHERE name = 'career.master_wizard.name'));