INSERT INTO skills_talents (skill_id, talent_id) VALUES
    -- Academic Knowledge (no talents)
    -- Animal Care (no talents)
    -- Animal Training (no talents)
    -- Blather (no talents)

    -- Channeling
    ((SELECT id FROM skills WHERE name = 'skill.channeling.name'), (SELECT id FROM talents WHERE name = 'talent.aethyric_attunement.name')),

    -- Charm
    ((SELECT id FROM skills WHERE name = 'skill.charm.name'), (SELECT id FROM talents WHERE name = 'talent.etiquette.name')),
    ((SELECT id FROM skills WHERE name = 'skill.charm.name'), (SELECT id FROM talents WHERE name = 'talent.master_orator.name')),
    ((SELECT id FROM skills WHERE name = 'skill.charm.name'), (SELECT id FROM talents WHERE name = 'talent.public_speaking.name')),
    ((SELECT id FROM skills WHERE name = 'skill.charm.name'), (SELECT id FROM talents WHERE name = 'talent.schemer.name')),
    ((SELECT id FROM skills WHERE name = 'skill.charm.name'), (SELECT id FROM talents WHERE name = 'talent.streetwise.name')),

    -- Charm Animal (no talents)
    -- Command (no talents)

    -- Common Knowledge
    ((SELECT id FROM skills WHERE name = 'skill.common_knowledge.name'), (SELECT id FROM talents WHERE name = 'talent.seasoned_traveller.name')),

    -- Concealment
    ((SELECT id FROM skills WHERE name = 'skill.concealment.name'), (SELECT id FROM talents WHERE name = 'talent.alley_cat.name')),
    ((SELECT id FROM skills WHERE name = 'skill.concealment.name'), (SELECT id FROM talents WHERE name = 'talent.rover.name')),
    ((SELECT id FROM skills WHERE name = 'skill.concealment.name'), (SELECT id FROM talents WHERE name = 'talent.tunnel_rat.name')),

    -- Consume Alcohol (no talents)

    -- Disguise
    ((SELECT id FROM skills WHERE name = 'skill.disguise.name'), (SELECT id FROM talents WHERE name = 'talent.mimic.name')),

    -- Dodge Blow (no talents)
    -- Drive (no talents)

    -- Evaluate
    ((SELECT id FROM skills WHERE name = 'skill.evaluate.name'), (SELECT id FROM talents WHERE name = 'talent.artistic.name')),
    ((SELECT id FROM skills WHERE name = 'skill.evaluate.name'), (SELECT id FROM talents WHERE name = 'talent.dealmaker.name')),

    -- Follow Trail (no talents)

    -- Gamble
    ((SELECT id FROM skills WHERE name = 'skill.gamble.name'), (SELECT id FROM talents WHERE name = 'talent.super_numerate.name')),

    -- Gossip
    ((SELECT id FROM skills WHERE name = 'skill.gossip.name'), (SELECT id FROM talents WHERE name = 'talent.etiquette.name')),
    ((SELECT id FROM skills WHERE name = 'skill.gossip.name'), (SELECT id FROM talents WHERE name = 'talent.streetwise.name')),

    -- Haggle
    ((SELECT id FROM skills WHERE name = 'skill.haggle.name'), (SELECT id FROM talents WHERE name = 'talent.dealmaker.name')),

    -- Heal
    ((SELECT id FROM skills WHERE name = 'skill.heal.name'), (SELECT id FROM talents WHERE name = 'talent.surgery.name')),

    -- Hypnotism (no talents)

    -- Intimidate
    ((SELECT id FROM skills WHERE name = 'skill.intimidate.name'), (SELECT id FROM talents WHERE name = 'talent.menacing.name')),

    -- Lip Reading
    ((SELECT id FROM skills WHERE name = 'skill.lip_reading.name'), (SELECT id FROM talents WHERE name = 'talent.excellent_vision.name')),

    -- Magical Sense
    ((SELECT id FROM skills WHERE name = 'skill.magical_sense.name'), (SELECT id FROM talents WHERE name = 'talent.aethyric_attunement.name')),

    -- Navigation
    ((SELECT id FROM skills WHERE name = 'skill.navigation.name'), (SELECT id FROM talents WHERE name = 'talent.orientation.name')),
    ((SELECT id FROM skills WHERE name = 'skill.navigation.name'), (SELECT id FROM talents WHERE name = 'talent.super_numerate.name')),

    -- Outdoor Survival (no talents)

    -- Perception
    ((SELECT id FROM skills WHERE name = 'skill.perception.name'), (SELECT id FROM talents WHERE name = 'talent.acute_hearing.name')),
    ((SELECT id FROM skills WHERE name = 'skill.perception.name'), (SELECT id FROM talents WHERE name = 'talent.excellent_vision.name')),
    ((SELECT id FROM skills WHERE name = 'skill.perception.name'), (SELECT id FROM talents WHERE name = 'talent.super_numerate.name')),
    ((SELECT id FROM skills WHERE name = 'skill.perception.name'), (SELECT id FROM talents WHERE name = 'talent.trapfinder.name')),

    -- Performer
    ((SELECT id FROM skills WHERE name = 'skill.performer.name'), (SELECT id FROM talents WHERE name = 'talent.contortionist.name')),
    ((SELECT id FROM skills WHERE name = 'skill.performer.name'), (SELECT id FROM talents WHERE name = 'talent.mimic.name')),

    -- Pick Locks
    ((SELECT id FROM skills WHERE name = 'skill.pick_locks.name'), (SELECT id FROM talents WHERE name = 'talent.trapfinder.name')),

    -- Prepare Poison (no talents)

    -- Read/Write
    ((SELECT id FROM skills WHERE name = 'skill.read_write.name'), (SELECT id FROM talents WHERE name = 'talent.linguistics.name')),

    -- Ride
    ((SELECT id FROM skills WHERE name = 'skill.ride.name'), (SELECT id FROM talents WHERE name = 'talent.trick_riding.name')),

    -- Row (no talents)

    -- Sail (no talents)

    -- Scale Sheer Surface (no talents)
    -- Search (no talents)
    -- Secret Language (no talents)
    -- Secret Signs (no talents)
    -- Set Trap (no talents)

    -- Silent Move
    ((SELECT id FROM skills WHERE name = 'skill.silent_move.name'), (SELECT id FROM talents WHERE name = 'talent.alley_cat.name')),
    ((SELECT id FROM skills WHERE name = 'skill.silent_move.name'), (SELECT id FROM talents WHERE name = 'talent.rover.name')),
    ((SELECT id FROM skills WHERE name = 'skill.silent_move.name'), (SELECT id FROM talents WHERE name = 'talent.tunnel_rat.name')),

    -- Shadowing (no talents)
    -- Sleight of Hand (no talents)
    -- Speak Arcane Language (no talents)

    -- Speak Language
    ((SELECT id FROM skills WHERE name = 'skill.speak_language.name'), (SELECT id FROM talents WHERE name = 'talent.linguistics.name')),
    ((SELECT id FROM skills WHERE name = 'skill.speak_language.name'), (SELECT id FROM talents WHERE name = 'talent.mimic.name')),
    ((SELECT id FROM skills WHERE name = 'skill.speak_language.name'), (SELECT id FROM talents WHERE name = 'talent.seasoned_traveller.name')),

    -- Swim (no talents)

    -- Torture
    ((SELECT id FROM skills WHERE name = 'skill.torture.name'), (SELECT id FROM talents WHERE name = 'talent.menacing.name')),

    -- Trade
    ((SELECT id FROM skills WHERE name = 'skill.trade.name'), (SELECT id FROM talents WHERE name = 'talent.artistic.name')),
    ((SELECT id FROM skills WHERE name = 'skill.trade.name'), (SELECT id FROM talents WHERE name = 'talent.dwarfcraft.name'));

    -- Ventriloquism (no talents);