package model;

class Building{
	int roomNo;
	int bathNo;
	public Building() {
		roomNo = 0;
		bathNo = 0;
	}
	public Building(int room, int bath) {
		roomNo = room;
		bathNo = bath;
	}
	@Override
	public String toString() {
		return roomNo + "\t" + bathNo;
	}
}

class Residential extends Building{	
}

class Commercial extends Building{
	double commonSpaceArea;
	public Commercial(int room, int bath, double area) {
		super(room, bath);
		commonSpaceArea = area;
	}
	public String toString() {
		return roomNo + "\t" + bathNo + "\t" + commonSpaceArea;
	}
}
	
class Townhouse extends Residential{
	int houseInRow;
	public Townhouse(int room, int bath, int houseNo) {
		roomNo = room;
		bathNo = bath;
		houseInRow = houseNo;
	}
		
	public String toString() {
		return roomNo + "\t" + bathNo + "\t" + houseInRow;
	}
}
	
class Detached extends Residential{
}
