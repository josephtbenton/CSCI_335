package maze.heuristics;

import maze.core.MazeCell;
import maze.core.MazeExplorer;
import search.core.BestFirstHeuristic;

import java.util.Set;
import java.util.SortedSet;

/**
 * Created by Joseph on 8/31/2015.
 */
public class FarthestTreasureFromGoal implements BestFirstHeuristic<MazeExplorer> {
    @Override
    public int getDistance(MazeExplorer node, MazeExplorer goal) {
        Set<MazeCell> treasures = node.getTreasure();
        SortedSet<MazeCell> visited = node.getTreasureFound();
        MazeCell farthest = null;
        for (MazeCell c : treasures) {
            farthest = farthest == null ? c : farthest;
            if (!visited.contains(c)) {
                farthest = goal.getLocation().getManhattanDist(c) > goal.getLocation().getManhattanDist(farthest) ? c : farthest; // update closest treasure if the new treasure is closer than the old.
            }
        }
        if (visited.size() == treasures.size()) {
            return node.getLocation().getManhattanDist(goal.getLocation());
        } else {
            return node.getLocation().getManhattanDist(farthest) + farthest.getManhattanDist(goal.getLocation());
        }
    }

}
