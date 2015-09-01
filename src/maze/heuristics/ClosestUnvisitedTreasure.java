package maze.heuristics;

import maze.core.MazeCell;
import maze.core.MazeExplorer;
import search.core.BestFirstHeuristic;

import java.util.Set;
import java.util.SortedSet;

/**
 * Created by Joseph on 8/31/2015.
 */
public class ClosestUnvisitedTreasure implements BestFirstHeuristic<MazeExplorer> {

    @Override
    public int getDistance(MazeExplorer node, MazeExplorer goal) {
        Set<MazeCell> treasures = node.getTreasure();
        SortedSet<MazeCell> visited = node.getTreasureFound();
        MazeCell closest = null;
        for (MazeCell c : treasures) {
            closest = closest == null ? c : closest;
            if (!visited.contains(c)) {
                closest = node.getLocation().getManhattanDist(c) < node.getLocation().getManhattanDist(closest) ? c : closest; // update closest treasure if the new treasure is closer than the old.
            }
        }
        if (visited.size() == treasures.size()) {
            return node.getLocation().getManhattanDist(goal.getLocation());
        } else {
            return node.getLocation().getManhattanDist(closest) + closest.getManhattanDist(goal.getLocation());
        }
    }
}
