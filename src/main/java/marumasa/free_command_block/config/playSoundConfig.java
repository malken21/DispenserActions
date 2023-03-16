package marumasa.free_command_block.config;

import org.bukkit.configuration.file.FileConfiguration;

public class playSoundConfig {

    public final String Sound;
    public final String Volume;
    public final String Pitch;
    public final String Category;
    public final String NotEnoughSettings;
    public final String ExceedingMaxVolume;
    public final String ExceedingMaxPitch;
    public final float MaxVolume;
    public final float MaxPitch;

    public playSoundConfig(FileConfiguration config) {

        //-----説明-----//
        Sound = config.getString("playSound.lore.sound");//サウンド
        Volume = config.getString("playSound.lore.volume");//ボリューム
        Pitch = config.getString("playSound.lore.pitch");//ピッチ
        Category = config.getString("playSound.lore.category");//サウンドカテゴリ
        //-----警告-----//
        NotEnoughSettings = config.getString("playSound.warnText.NotEnoughSettings");//設定項目が足りない
        ExceedingMaxVolume = config.getString("playSound.warnText.ExceedingMaxVolume");//最大の音量を超えている
        ExceedingMaxPitch = config.getString("playSound.warnText.ExceedingMaxPitch");//最大のピッチを超えている
        //-----制限-----//
        MaxVolume = (float) config.getDouble("playSound.maxVolume");//最大ボリューム
        MaxPitch = (float) config.getDouble("playSound.maxPitch");//最大ピッチ
    }
}
