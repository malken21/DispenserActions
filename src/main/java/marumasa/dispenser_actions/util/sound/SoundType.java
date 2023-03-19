package marumasa.dispenser_actions.util.sound;

import org.bukkit.SoundCategory;

public class SoundType {
    public static SoundCategory get(String text) {
        if (text.equalsIgnoreCase("MASTER")) {
            return SoundCategory.MASTER;
        }
        if (text.equalsIgnoreCase("MUSIC")) {
            return SoundCategory.MUSIC;
        }
        if (text.equalsIgnoreCase("RECORDS")) {
            return SoundCategory.RECORDS;
        }
        if (text.equalsIgnoreCase("WEATHER")) {
            return SoundCategory.WEATHER;
        }
        if (text.equalsIgnoreCase("HOSTILE")) {
            return SoundCategory.HOSTILE;
        }
        if (text.equalsIgnoreCase("NEUTRAL")) {
            return SoundCategory.NEUTRAL;
        }
        if (text.equalsIgnoreCase("PLAYERS")) {
            return SoundCategory.PLAYERS;
        }
        if (text.equalsIgnoreCase("AMBIENT")) {
            return SoundCategory.AMBIENT;
        }
        if (text.equalsIgnoreCase("VOICE")) {
            return SoundCategory.VOICE;
        }
        return null;
    }
}