package net.blerf.ftl.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import net.blerf.ftl.parser.SavedGameParser.SystemType;


@XmlRootElement(name="shipBlueprint")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShipBlueprint {
	
	@XmlAttribute(name="name")
	private String id;
	@XmlAttribute
	private String layout;
	@XmlAttribute(name="img")
	private String gfxBaseName;
	
	@XmlElement(name="class")
	private String shipClass;
	private String name, desc;
	
	private SystemList systemList;
	private Health health;
	private MaxPower maxPower;
	@XmlElement(required=false)  // Not present in autoBlueprints.xml.
	private Integer weaponSlots, droneSlots;
	@XmlElement(required=false)
	private WeaponList weaponList;
	@XmlElement(name="aug",required=false)
	private List<AugmentId> augmentIds;
	@XmlElement(required=false)
	private DroneList droneList;

	private Object crewCount;  // TODO: model
	@XmlElement(required=false)
	private Object boardingAI;  // TODO: model
	
	@XmlRootElement
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class SystemList {

		@XmlRootElement
		@XmlAccessorType(XmlAccessType.FIELD)
		public static class RoomSlot {
			@XmlElement(required=false)
			private String direction;
			@XmlElement
			private int number;
			
			public String getDirection() {
				return direction;
			}
			public void setDirection( String direction ) {
				this.direction = direction;
			}
			public int getNumber() {
				return number;
			}
			public void setNumber( int number ) {
				this.number = number;
			}
			
		}
		
		@XmlRootElement
		@XmlAccessorType(XmlAccessType.FIELD)
		public static class SystemRoom {
			
			@XmlAttribute
			private int power;
			@XmlAttribute(name="max",required=false)
			private Integer maxPower;  // Overrides SystemBlueprint's maxPower.
			@XmlAttribute(name="room")
			private int roomId;
			@XmlAttribute(required=false)
			private Boolean start;  // Treat null omissions as as true.
			@XmlAttribute(required=false)
			private String img;
			@XmlElement(required=false)
			private RoomSlot slot;
			
			public int getPower() {
				return power;
			}
			public void setPower( int power ) {
				this.power = power;
			}
			public Integer getMaxPower() {
				return maxPower;
			}
			public void setMaxPower( Integer maxPower ) {
				this.maxPower = maxPower;
			}
			public int getRoomId() {
				return roomId;
			}
			public void setRoomId( int roomId ) {
				this.roomId = roomId;
			}
			public Boolean getStart() {
				return start;
			}
			public void setStart( Boolean start ) {
				this.start = start;
			}
			public String getImg() {
				return img;
			}
			public void setImg( String img ) {
				this.img = img;
			}
			public RoomSlot getSlot() {
				return slot;
			}
			public void setSlot( RoomSlot slot ) {
				this.slot = slot;
			}
			
		}
		
		@XmlElement(name="pilot")
		private SystemRoom pilotRoom;
		@XmlElement(name="doors")
		private SystemRoom doorsRoom;
		@XmlElement(name="sensors")
		private SystemRoom sensorsRoom;
		@XmlElement(name="medbay")
		private SystemRoom medicalRoom;
		@XmlElement(name="oxygen")
		private SystemRoom lifeSupportRoom;
		@XmlElement(name="shields")
		private SystemRoom shieldRoom;
		@XmlElement(name="engines")
		private SystemRoom engineRoom;
		@XmlElement(name="weapons")
		private SystemRoom weaponRoom;
		@XmlElement(name="drones")
		private SystemRoom droneRoom;
		@XmlElement(name="teleporter")
		private SystemRoom teleporterRoom;
		@XmlElement(name="cloaking")
		private SystemRoom cloakRoom;  // lol :)
		@XmlElement(name="artillery",required=false)
		private List<SystemRoom> artilleryRooms;
		
		public SystemRoom[] getSystemRooms() {
			SystemRoom[] rooms = new SystemRoom[] { pilotRoom, doorsRoom, sensorsRoom, medicalRoom, lifeSupportRoom, shieldRoom, 
					engineRoom, weaponRoom, droneRoom, teleporterRoom, cloakRoom };
			List<SystemRoom> list = new ArrayList<SystemRoom>();
			for ( SystemRoom room : rooms ) {
				if( room != null ) list.add(room);
			}
			if( artilleryRooms != null )
				list.addAll(artilleryRooms);
			return list.toArray(new SystemRoom[list.size()]);
		}
		
		public SystemRoom getPilotRoom() {
			return pilotRoom;
		}
		public void setPilotRoom( SystemRoom pilotRoom ) {
			this.pilotRoom = pilotRoom;
		}
		public SystemRoom getDoorsRoom() {
			return doorsRoom;
		}
		public void setDoorsRoom( SystemRoom doorsRoom ) {
			this.doorsRoom = doorsRoom;
		}
		public SystemRoom getSensorsRoom() {
			return sensorsRoom;
		}
		public void setSensorsRoom( SystemRoom sensorsRoom ) {
			this.sensorsRoom = sensorsRoom;
		}
		public SystemRoom getMedicalRoom() {
			return medicalRoom;
		}
		public void setMedicalRoom( SystemRoom medicalRoom ) {
			this.medicalRoom = medicalRoom;
		}
		public SystemRoom getLifeSupportRoom() {
			return lifeSupportRoom;
		}
		public void setLifeSupportRoom( SystemRoom lifeSupportRoom ) {
			this.lifeSupportRoom = lifeSupportRoom;
		}
		public SystemRoom getShieldRoom() {
			return shieldRoom;
		}
		public void setShieldRoom( SystemRoom shieldRoom ) {
			this.shieldRoom = shieldRoom;
		}
		public SystemRoom getEngineRoom() {
			return engineRoom;
		}
		public void setEngineRoom( SystemRoom engineRoom ) {
			this.engineRoom = engineRoom;
		}
		public SystemRoom getWeaponRoom() {
			return weaponRoom;
		}
		public void setWeaponRoom( SystemRoom weaponRoom ) {
			this.weaponRoom = weaponRoom;
		}
		public SystemRoom getDroneRoom() {
			return droneRoom;
		}
		public void setDroneRoom( SystemRoom droneRoom ) {
			this.droneRoom = droneRoom;
		}
		public SystemRoom getTeleporterRoom() {
			return teleporterRoom;
		}
		public void setTeleporterRoom( SystemRoom teleporterRoom ) {
			this.teleporterRoom = teleporterRoom;
		}
		public SystemRoom getCloakRoom() {
			return cloakRoom;
		}
		public void setCloakRoom( SystemRoom cloakRoom ) {
			this.cloakRoom = cloakRoom;
		}
		public List<SystemRoom> getArtilleryRooms() {
			return artilleryRooms;
		}
		public void setArtilleryRooms( List<SystemRoom> artilleryRooms ) {
			this.artilleryRooms = artilleryRooms;
		}

		/**
		 * Returns SystemRooms, or null if not present.
		 *
		 * @return an array of SystemRooms, usually only containing one
		 */
		public SystemList.SystemRoom[] getSystemRoom( SystemType systemType ) {
			SystemList.SystemRoom systemRoom = null;
			if ( SystemType.PILOT.equals(systemType) ) systemRoom = getPilotRoom();
			else if ( SystemType.DOORS.equals(systemType) ) systemRoom = getDoorsRoom();
			else if ( SystemType.SENSORS.equals(systemType) ) systemRoom = getSensorsRoom();
			else if ( SystemType.MEDBAY.equals(systemType) ) systemRoom = getMedicalRoom();
			else if ( SystemType.OXYGEN.equals(systemType) ) systemRoom = getLifeSupportRoom();
			else if ( SystemType.SHIELDS.equals(systemType) ) systemRoom = getShieldRoom();
			else if ( SystemType.ENGINES.equals(systemType) ) systemRoom = getEngineRoom();
			else if ( SystemType.WEAPONS.equals(systemType) ) systemRoom = getWeaponRoom();
			else if ( SystemType.DRONE_CTRL.equals(systemType) ) systemRoom = getDroneRoom();
			else if ( SystemType.TELEPORTER.equals(systemType) ) systemRoom = getTeleporterRoom();
			else if ( SystemType.CLOAKING.equals(systemType) ) systemRoom = getCloakRoom();
			if ( systemRoom != null ) return new SystemList.SystemRoom[] { systemRoom };

			if ( SystemType.ARTILLERY.equals(systemType) ) {
				if ( getArtilleryRooms() != null && getArtilleryRooms().size() > 0 ) {
					int n = 0;
					SystemList.SystemRoom[] result = new SystemList.SystemRoom[getArtilleryRooms().size()];
					for ( SystemRoom artilleryRoom : artilleryRooms ) {
						result[n++] = artilleryRoom;
					}
					return result;
				}
			}

			return null;
		}

		/**
		 * Returns the SystemType in a given room, or null.
		 */
		public SystemType getSystemTypeByRoomId( int roomId ) {
			for ( SystemType systemType : SystemType.values() ) {
				SystemList.SystemRoom[] systemRooms = getSystemRoom( systemType );
				if ( systemRooms != null ) {
					for ( SystemList.SystemRoom systemRoom : systemRooms ) {
						if ( systemRoom.getRoomId() == roomId )
							return systemType;
					}
				}
			}
			return null;
		}

		/**
		 * Returns roomId(s) that contain a given system, or null.
		 *
		 * @return an array of roomIds, usually only containing one
		 */
		public int[] getRoomIdBySystemType( SystemType systemType ) {
			int[] result = null;
			SystemList.SystemRoom[] systemRooms = getSystemRoom( systemType );
			if ( systemRooms != null ) {
				result = new int[ systemRooms.length ];
				for (int i=0; i < systemRooms.length; i++)
					result[i] = systemRooms[i].getRoomId();
			}
			return result;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class WeaponList {
		// 'count' isn't an independent field; a getter/setter calc's it.

		@XmlAttribute
		public int missiles;
		@XmlAttribute(name="load",required=false)
		public String blueprintListId;
		@XmlElement(name="weapon")
		private List<WeaponId> weaponIds;

		@XmlAccessorType(XmlAccessType.FIELD)
		public static class WeaponId {
			@XmlAttribute
			public String name;
		}

		@XmlAttribute(name="count")
		public int getCount() {
			return (weaponIds != null ? weaponIds.size() : 0);
		}

		public void setCount( int n ) { /* No-op */ }

		public List<WeaponId> getWeaponIds() {
			return weaponIds;
		}

		public void setWeaponIds( List<WeaponId> weaponIds ) {
			this.weaponIds = weaponIds;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class AugmentId {
		@XmlAttribute
		public String name;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class DroneList {
		// 'count' isn't an independent field; a getter/setter calc's it.

		@XmlAttribute
		public int drones;
		@XmlAttribute(name="load",required=false)
		public String blueprintListId;
		@XmlElement(name="drone")
		private List<DroneId> droneIds;

		@XmlAccessorType(XmlAccessType.FIELD)
		public static class DroneId {
			@XmlAttribute
			public String name;
		}

		@XmlAttribute(name="count")
		public int getCount() {
			return (droneIds != null ? droneIds.size() : 0);
		}

		public void setCount( int n ) { /* No-op */ }

		public List<DroneId> getDroneIds() {
			return droneIds;
		}

		public void setDroneIds( List<DroneId> droneIds ) {
			this.droneIds = droneIds;
		}
	}

	@XmlRootElement
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Health {
		@XmlAttribute
		public int amount;
	}

	@XmlRootElement
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class MaxPower {
		@XmlAttribute
		public int amount;
	}

	public String getId() {
		return id;
	}

	public void setId( String id ) {
		this.id = id;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout( String layout ) {
		this.layout = layout;
	}

	public String getGraphicsBaseName() {
		return gfxBaseName;
	}

	public void setGraphicsBaseName( String gfxBaseName ) {
		this.gfxBaseName = gfxBaseName;
	}

	public String getShipClass() {
		return shipClass;
	}

	public void setShipClass( String shipClass ) {
		this.shipClass = shipClass;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc( String desc ) {
		this.desc = desc;
	}

	public SystemList getSystemList() {
		return systemList;
	}

	public void setSystemList( SystemList systemList ) {
		this.systemList = systemList;
	}

	public Integer getWeaponSlots() {
		return weaponSlots;
	}

	public void setWeaponSlots( Integer weaponSlots ) {
		this.weaponSlots = weaponSlots;
	}

	public Integer getDroneSlots() {
		return droneSlots;
	}

	public void setDroneSlots( Integer droneSlots ) {
		this.droneSlots = droneSlots;
	}

	public WeaponList getWeaponList() {
		return weaponList;
	}

	public void setWeaponList( WeaponList weaponList ) {
		this.weaponList = weaponList;
	}

	public List<AugmentId> getAugments() {
		return augmentIds;
	}

	public void setAugments( List<AugmentId> augmentIds ) {
		this.augmentIds = augmentIds;
	}

	public DroneList getDroneList() {
		return droneList;
	}

	public void setDroneList( DroneList droneList ) {
		this.droneList = droneList;
	}

	public Health getHealth() {
		return health;
	}

	public void setHealth( Health health ) {
		this.health = health;
	}

	public MaxPower getMaxPower() {
		return maxPower;
	}

	public void setMaxPower( MaxPower maxPower ) {
		this.maxPower = maxPower;
	}

	public Object getCrewCount() {
		return crewCount;
	}

	public void setCrewCount( Object crewCount ) {
		this.crewCount = crewCount;
	}

	@Override
	public String toString() {
		return String.format("%s (%s)", id, shipClass);
	}
}
