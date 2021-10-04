package preparation.graph;

import preparation.util.Node;
import preparation.util.VNode;

import java.awt.desktop.SystemEventListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Test29MinimumStepsToWinSnakeLadderProblem {
    public static void main(String[] args) {
        // snakes and ladders are represented using a map.
        Map<Integer, Integer> ladder = new HashMap();
        Map<Integer, Integer> snake = new HashMap();

        // insert ladders into the map
        ladder.put(1, 38);
        ladder.put(4, 14);
        ladder.put(9, 31);
        ladder.put(21, 42);
        ladder.put(28, 84);
        ladder.put(51, 67);
        ladder.put(72, 91);
        ladder.put(80, 99);

        // insert snakes into the map
        snake.put(17, 7);
        snake.put(54, 34);
        snake.put(62, 19);
        snake.put(64, 60);
        snake.put(87, 36);
        snake.put(93, 73);
        snake.put(95, 75);
        snake.put(98, 79);

        int steps = findSolution(ladder, snake);
        System.out.print(steps);
    }

    private static int findSolution(Map<Integer, Integer> ladder, Map<Integer, Integer> snake) {
        Node<Integer> src = new Node<>(0,0);
        Queue<Node<Integer>> q = new LinkedList<>();
        q.add(src);

        int[] possibleDiceRolls = {1, 2, 3, 4, 5, 6};

        while(!q.isEmpty()){
            Node<Integer> curr = q.poll();

            if(curr.data == 100){
                return curr.step;
            }

            boolean ladderOrSnakeFound = false;
            for(int i=0; i<possibleDiceRolls.length; i++) {
                int v = possibleDiceRolls[i] + curr.data;;
                if (ladder.containsKey(v)) {
                    q.add(new Node(ladder.get(v), curr.step + 1));

                } else if (snake.containsKey(v)) {
                    q.add(new Node(snake.get(v), curr.step + 1));

                } else{
                    q.add(new Node<>(v, curr.step+1));
                }

            }
        }
        return -1;
    }

}
