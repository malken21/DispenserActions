package marumasa.free_command_block.config;

import org.bukkit.configuration.file.FileConfiguration;

public class stopSoundConfig {

    public final String Sound;
    public final String Distance;
    public final String Category;
    public final String NotEnoughSettings;
    public final String ExceedingMaxDistance;
    public final float MaxDistance;

    public stopSoundConfig(FileConfiguration config) {

        //-----表示名-----//
        Sound = config.getString("stopSound.lore.sound");//サウンド
        Distance = config.getString("stopSound.lore.distance");//距離
        Category = config.getString("stopSound.lore.category");//サウンドカテゴリ
        //-----警告-----//
        NotEnoughSettings = config.getString("stopSound.warnText.NotEnoughSettings");//設定項目が足りない
        ExceedingMaxDistance = config.getString("stopSound.warnText.ExceedingMaxDistance");//最大の音量を超えている
        //-----設定-----//
        MaxDistance = (float) config.getDouble("stopSound.maxDistance");//最大距離
    }
}
