package marumasa.free_command_block.util.sound;

import org.bukkit.SoundCategory;

import java.util.Objects;

public class blockType {
    public static SoundCategory get(String data) {
        if (Objects.equals(data, "MASTER")) {
            return SoundCategory.MASTER;
        }
        if (Objects.equals(data, "MUSIC")) {
            return SoundCategory.MUSIC;
        }
        if (Objects.equals(data, "RECORDS")) {
            return SoundCategory.RECORDS;
        }
        if (Objects.equals(data, "WEATHER")) {
            return SoundCategory.WEATHER;
        }
        if (Objects.equals(data, "HOSTILE")) {
            return SoundCategory.HOSTILE;
        }
        if (Objects.equals(data, "NEUTRAL")) {
            return SoundCategory.NEUTRAL;
        }
        if (Objects.equals(data, "PLAYERS")) {
            return SoundCategory.PLAYERS;
        }
        if (Objects.equals(data, "AMBIENT")) {
            return SoundCategory.AMBIENT;
        }
        if (Objects.equals(data, "VOICE")) {
            return SoundCategory.VOICE;
        }
        return null;
    }
}