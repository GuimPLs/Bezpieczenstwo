package pl.guimpl.bezpieczenstwo;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class ReportListener implements Listener {

    private final ReportManager reportManager;

    public ReportListener(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Możemy dodać kod do powiadamiania nowych graczy o zgłoszeniach lub innych wydarzeniach
    }
}
