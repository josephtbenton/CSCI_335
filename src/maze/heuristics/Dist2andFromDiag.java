package maze.heuristics;

import maze.core.MazeCell;
import maze.core.MazeExplorer;
import search.core.BestFirstHeuristic;

import java.util.Set;
import java.util.SortedSet;

/**
 * Created by Joseph on 9/1/2015.
 */
public class Dist2andFromDiag implements BestFirstHeuristic<MazeExplorer> {
    @Override
    public int getDistance(MazeExplorer node, MazeExplorer goal) {
        Set<MazeCell> treasures = node.getTreasure();
        SortedSet<MazeCell> visited = node.getTreasureFound();
        int result = node.getLocation().getManhattanDist(goal.getLocation());
        for (MazeCell c : treasures) {
            if (!visited.contains(c)) {
                result += 2 * Math.abs(c.Y()-c.X());
            }
        }
        return result;
    }

}
