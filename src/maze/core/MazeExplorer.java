package maze.core;

import java.util.*;

import search.core.BestFirstObject;

public class MazeExplorer implements BestFirstObject<MazeExplorer> {
	private Maze m;
	private MazeCell location;
	private TreeSet<MazeCell> treasureFound; 
	
	public MazeExplorer(Maze m, MazeCell location) {
		this.m = m;
		this.location = location;
		treasureFound = new TreeSet<MazeCell>();
	}
	
	public MazeCell getLocation() {return location;}

	@Override
	public ArrayList<MazeExplorer> getSuccessors() {
		ArrayList<MazeExplorer> result = new ArrayList<MazeExplorer>();
       for (Direction d : Direction.values()) {
           if (!m.blocked(location, d)) {
               result.add(new MazeExplorer(m, d.successor(location)));
           }
       }
        for (MazeExplorer i : result) {
            i.addTreasures(treasureFound);
            if (m.isTreasure(i.getLocation())) {
                i.treasureFound.add(i.getLocation());
            }
        }
        return result;
	}
	
	public void addTreasures(Collection<MazeCell> treasures) {
		treasureFound.addAll(treasures);
	}
	
	public String toString() {
		StringBuilder treasures = new StringBuilder();
		for (MazeCell t: treasureFound) {
			treasures.append(";");
			treasures.append(t.toString());
		}
		return "@" + location.toString() + treasures.toString();
	}
	public Set<MazeCell> getTreasure() {return Collections.unmodifiableSet(m.getTreasures());}
	public SortedSet<MazeCell> getTreasureFound() {return Collections.unmodifiableSortedSet(treasureFound);}

	@Override
	public int hashCode() {return toString().hashCode();}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof MazeExplorer) {
			return achieves((MazeExplorer)other);
		} else {
			return false;
		}
	}

	@Override
	public boolean achieves(MazeExplorer goal) {
		return this.location.equals(goal.location) && this.treasureFound.equals(goal.treasureFound);
	}

}
