package pl.guimpl.bezpieczenstwo;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class ModeratorManager {

    private final Set<String> moderators = new HashSet<>();

    public ModeratorManager(Bezpieczenstwo plugin) {
        // Dodaj domyślnych moderatorów lub załaduj z konfiguracji
        // Można również dodać możliwość dodawania moderatorów przez komendy
        moderators.add("Moderator1");
        moderators.add("Moderator2");
    }

    public void notifyModerators(String message) {
        for (String moderatorName : moderators) {
            Player moderator = Bukkit.getPlayer(moderatorName);
            if (moderator != null) {
                moderator.sendMessage("§e[Bezpieczenstwo] " + message);
            }
        }
    }

    public boolean isModerator(Player player) {
        return moderators.contains(player.getName());
    }
}
