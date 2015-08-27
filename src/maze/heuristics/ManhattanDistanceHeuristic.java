package maze.heuristics;

import maze.core.MazeExplorer;
import search.core.BestFirstHeuristic;

/**
 * Created by Joseph on 8/26/2015.
 */
public class ManhattanDistanceHeuristic implements BestFirstHeuristic<MazeExplorer> {
    @Override
    public int getDistance(MazeExplorer node, MazeExplorer goal) {
        return node.getLocation().getManhattanDist(goal.getLocation());
    }
}
