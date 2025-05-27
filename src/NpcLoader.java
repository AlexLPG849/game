import java.io.FileReader;
import java.util.*;
import com.google.gson.*;

public class NpcLoader {
    public List<NPC> loadNpcs(String filePath) {
        List<NPC> npcs = new ArrayList<>();
        try {
            Gson gson = new Gson();
            JsonArray npcArray = gson.fromJson(new FileReader(filePath), JsonArray.class);

            for (JsonElement element : npcArray) {
                JsonObject npcObj = element.getAsJsonObject();
                String name = npcObj.get("name").getAsString();
                String preferredSubstance = npcObj.get("preferredSubstance").getAsString();
                String location = npcObj.get("location").getAsString();
                String startingNode = npcObj.get("startingNode").getAsString();


                NPC npc = new NPC(name, preferredSubstance, location, startingNode);
                npcs.add(npc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return npcs;
    }
}
