package maze.heuristics;

import maze.core.MazeCell;
import maze.core.MazeExplorer;
import search.core.BestFirstHeuristic;

import java.util.Set;
import java.util.SortedSet;

/**
 * Created by Joseph on 8/31/2015.
 */
public class GreedyTreasures implements BestFirstHeuristic<MazeExplorer> {
    @Override
    public int getDistance(MazeExplorer node, MazeExplorer goal) {
        Set<MazeCell> treasures = node.getTreasure();
        SortedSet<MazeCell> visited = node.getTreasureFound();
        int result = node.getLocation().getManhattanDist(goal.getLocation());
        for (MazeCell c : treasures) {
            if (!visited.contains(c)) {
                result += node.getLocation().getManhattanDist(c);
            }
        }
        return result;
    }
}
