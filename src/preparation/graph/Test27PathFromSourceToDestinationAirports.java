package preparation.graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test27PathFromSourceToDestinationAirports
{

    public static void main(String[] args)
    {
        /*
        departure is scheduled from evert airport except final destination and each airport is
        visted only once...no cycle

        HKG —> DXB
        FRA —> HKG
        DEL —> FRA

        Output: DEL —> FRA —> HKG —> DXB
         */
        // input: list of tickets
        String[][] input = new String[][]{
            {"LAX", "DXB"},
            {"DFW", "JFK"},
            {"LHR", "DFW"},
            {"JFK", "LAX"}
        };

        /*
        check for source airport (it would be the one which is not present in destination
        airports) and then if it is formed as
        as graph then do bfs or dfs, otherwise simply use recursion
         */
        findItinerary(input);
    }

    private static void findItinerary(String[][] input)
    {
        Map<String, String> tickets = Stream.of(input)
            .collect(Collectors.toMap(p -> p[0], p -> p[1]));
        String source = findSourceAirport(tickets);

        if (source != null && source.length() > 0)
        {
            System.out.print(findPath(source, tickets));
            return;
        }

        System.out.print("Wrong Input");
    }

    private static String findPath(String source, Map<String, String> tickets)
    {
        if (tickets.get(source) == null)
        {
            return "";
        }

        return source + "->" + findPath(tickets.get(source), tickets);
    }

    private static String findSourceAirport(Map<String, String> tickets)
    {
        Set<String> destinationAirports = new HashSet<>(tickets.values());

        Optional<String> srcOptional = tickets.keySet().stream()
            .filter(src -> !destinationAirports.contains(src)).findFirst();
        if (srcOptional.isPresent())
        {
            return srcOptional.get();
        } else
        {
            return "";
        }
    }
}
