package pl.guimpl.bezpieczenstwo;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Report {

    private final UUID playerUUID;
    private final String reason;
    private String resolvedBy;

    public Report(UUID playerUUID, String reason, String resolvedBy) {
        this.playerUUID = playerUUID;
        this.reason = reason;
        this.resolvedBy = resolvedBy;
    }

    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public String getReason() {
        return reason;
    }

    public String getResolvedBy() {
        return resolvedBy;
    }

    public void setResolvedBy(String resolvedBy) {
        this.resolvedBy = resolvedBy;
    }

    public String getPlayerName() {
        Player player = Bukkit.getPlayer(playerUUID);
        return (player != null) ? player.getName() : "Nieznany gracz";
    }
}
