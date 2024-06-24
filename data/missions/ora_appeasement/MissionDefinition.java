package data.missions.ora_appeasement;

import com.fs.starfarer.api.campaign.CargoAPI;
import com.fs.starfarer.api.fleet.FleetGoal;
//import com.fs.starfarer.api.fleet.FleetMemberAPI;
import com.fs.starfarer.api.fleet.FleetMemberType;
import com.fs.starfarer.api.mission.FleetSide;
import com.fs.starfarer.api.mission.MissionDefinitionAPI;
import com.fs.starfarer.api.mission.MissionDefinitionPlugin;

public class MissionDefinition implements MissionDefinitionPlugin {
    @Override
	public void defineMission(MissionDefinitionAPI api) {

	
		// Set up the fleets so we can add ships and fighter wings to them.
		// In this scenario, the fleets are attacking each other, but
		// in other scenarios, a fleet may be defending or trying to escape
		api.initFleet(FleetSide.PLAYER, "ANS", FleetGoal.ATTACK, false);
		api.initFleet(FleetSide.ENEMY, "CDF", FleetGoal.ATTACK, true);

		// Set a small blurb for each fleet that shows up on the mission detail and
		// mission results screens to identify each side.
		api.setFleetTagline(FleetSide.PLAYER, "Alliance detachment");
		api.setFleetTagline(FleetSide.ENEMY, "Splinter Camillian Defense Fleet group");
		
		// These show up as items in the bulleted list under 
		// "Tactical Objectives" on the mission detail screen
		api.addBriefingItem("Rout the enemy.");
		api.addBriefingItem("Your ships are very susceptible to kinetic weapons and missiles.");
		api.addBriefingItem("Customize your loadouts to stand a better chance.");
		
		// Set up the player's fleet.  Variant names come from the
		// files in data/variants and data/variants/fighters
                
                api.addToFleet(FleetSide.PLAYER, "ora_beatitude_artillery", FleetMemberType.SHIP, true); 
//                api.addToFleet(FleetSide.PLAYER, "ora_beatitude_artillery", FleetMemberType.SHIP, false, CargoAPI.CrewXPLevel.ELITE);                
                
                api.addToFleet(FleetSide.PLAYER, "ora_harmony_blaster", FleetMemberType.SHIP, false);
                api.addToFleet(FleetSide.PLAYER, "ora_harmony_blaster", FleetMemberType.SHIP, false);
//                api.addToFleet(FleetSide.PLAYER, "ora_harmony_blaster", FleetMemberType.SHIP, false, CargoAPI.CrewXPLevel.VETERAN);
                api.addToFleet(FleetSide.PLAYER, "ora_mirth_pulse", FleetMemberType.SHIP, false);
                api.addToFleet(FleetSide.PLAYER, "ora_mirth_support", FleetMemberType.SHIP, false);
                api.addToFleet(FleetSide.PLAYER, "ora_bliss_pulse", FleetMemberType.SHIP, false);
//                api.addToFleet(FleetSide.PLAYER, "ora_bliss_pulse", FleetMemberType.SHIP, false, CargoAPI.CrewXPLevel.VETERAN);
//                api.addToFleet(FleetSide.PLAYER, "ora_bliss_support", FleetMemberType.SHIP, false, CargoAPI.CrewXPLevel.VETERAN);  
                api.addToFleet(FleetSide.PLAYER, "ora_bliss_support", FleetMemberType.SHIP, false);               
                
                api.addToFleet(FleetSide.PLAYER, "ora_felicity_support", FleetMemberType.SHIP, false);
//                api.addToFleet(FleetSide.PLAYER, "ora_fervor_wing", FleetMemberType.FIGHTER_WING, false);
                
                
			
		// Set up the enemy fleet.
//		api.addToFleet(FleetSide.ENEMY, "dominator_AntiCV", FleetMemberType.SHIP, false, CargoAPI.CrewXPLevel.VETERAN); 
                
		api.addToFleet(FleetSide.ENEMY, "dominator_d_Assault", FleetMemberType.SHIP, false);   
                
//		api.addToFleet(FleetSide.ENEMY, "eagle_d_Assault", FleetMemberType.SHIP, false);
		api.addToFleet(FleetSide.ENEMY, "eagle_Balanced", FleetMemberType.SHIP, false);   
                
//		api.addToFleet(FleetSide.ENEMY, "gryphon_FS", FleetMemberType.SHIP, false, CargoAPI.CrewXPLevel.VETERAN);
                
		api.addToFleet(FleetSide.ENEMY, "sunder_Assault", FleetMemberType.SHIP, false);
		api.addToFleet(FleetSide.ENEMY, "sunder_d_Assault", FleetMemberType.SHIP, false);
		api.addToFleet(FleetSide.ENEMY, "hammerhead_Tutorial", FleetMemberType.SHIP, false);
		api.addToFleet(FleetSide.ENEMY, "hammerhead_d_CS", FleetMemberType.SHIP, false);
//		api.addToFleet(FleetSide.ENEMY, "enforcer_Escort", FleetMemberType.SHIP, false);
                
		api.addToFleet(FleetSide.ENEMY, "wolf_Strike", FleetMemberType.SHIP, false);
		api.addToFleet(FleetSide.ENEMY, "brawler_Starting", FleetMemberType.SHIP, false);
//		api.addToFleet(FleetSide.ENEMY, "brawler_Elite", FleetMemberType.SHIP, false, CargoAPI.CrewXPLevel.VETERAN);
		api.addToFleet(FleetSide.ENEMY, "monitor_Escort", FleetMemberType.SHIP, false);
//		api.addToFleet(FleetSide.ENEMY, "monitor_Escort", FleetMemberType.SHIP, false);
//		api.addToFleet(FleetSide.ENEMY, "vigilance_AP", FleetMemberType.SHIP, false, CargoAPI.CrewXPLevel.VETERAN);
		api.addToFleet(FleetSide.ENEMY, "lasher_d_CS", FleetMemberType.SHIP, false);
                
                
                
		
                
		// Set up the map.
		float width = 15000f;
		float height = 18000f;
		api.initMap((float)-width/2f, (float)width/2f, (float)-height/2f, (float)height/2f);
		
		float minX = -width/2;
		float minY = -height/2;
		
		// All the addXXX methods take a pair of coordinates followed by data for
		// whatever object is being added.
		
		// And a few random ones to spice up the playing field.
		// A similar approach can be used to randomize everything
		// else, including fleet composition.
		for (int i = 0; i < 2; i++) {
			float x = (float) Math.random() * width - width/2;
			float y = (float) Math.random() * height - height/2;
			float radius = 100f + (float) Math.random() * 800f; 
			api.addNebula(x, y, radius);
		}
		
                api.addAsteroidField(0, 0, -90, 18000, 20, 25, 300);
                
		// Add objectives. These can be captured by each side
		// and provide stat bonuses and extra command points to
		// bring in reinforcements.
		// Reinforcements only matter for large fleets - in this
		// case, assuming a 100 command point battle size,
		// both fleets will be able to deploy fully right away.

		api.addObjective(minX + width * 0.7f, minY + height * 0.55f, "sensor_array");
		api.addObjective(minX + width * 0.3f, minY + height * 0.45f, "comm_relay");
		
		
	}

}
