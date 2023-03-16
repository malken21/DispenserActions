package marumasa.free_command_block;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

public class Config {

    public final Map<String, String> playSoundLore = new HashMap<>();
    public final Map<String, Float> playSound_F = new HashMap<>();

    public final Map<String, String> stopSound_S = new HashMap<>();
    public final Map<String, Float> stopSound_F = new HashMap<>();

    public Config(minecraft plugin) {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();

        //-----表示名-----//
        playSoundLore.put("sound", config.getString("playSound.lore.sound"));//サウンド
        playSoundLore.put("volume", config.getString("playSound.lore.volume"));//ボリューム
        playSoundLore.put("pitch", config.getString("playSound.lore.pitch"));//ピッチ
        playSoundLore.put("category", config.getString("playSound.lore.category"));//サウンドカテゴリ
        //-----設定-----//
        playSound_F.put("maxVolume", (float) config.getDouble("playSound.maxVolume"));//最大ボリューム
        playSound_F.put("maxPitch", (float) config.getDouble("playSound.maxPitch"));//最大ピッチ

        //-----表示名-----//
        stopSound_S.put("sound", config.getString("stopSound.lore.sound"));//サウンド
        stopSound_S.put("distance", config.getString("stopSound.lore.distance"));//距離
        stopSound_S.put("category", config.getString("stopSound.lore.category"));//サウンドカテゴリ
        //-----設定-----//
        stopSound_F.put("maxDistance", (float) config.getDouble("stopSound.maxDistance"));//最大距離
    }
}