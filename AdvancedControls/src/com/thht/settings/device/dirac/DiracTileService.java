package com.thht.settings.device.dirac;

import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

public class DiracTileService extends TileService {

    @Override
    public void onStartListening() {

        Tile tile = getQsTile();
        if (AudioEnhancerService.du.hasInitialized() && 
            AudioEnhancerService.du.isEnabled(getApplicationContext())) {
            tile.setState(Tile.STATE_ACTIVE);
        } else {
            tile.setState(Tile.STATE_INACTIVE);
        }

        tile.updateTile();

        super.onStartListening();
    }

    @Override
    public void onClick() {
        if (!AudioEnhancerService.du.hasInitialized())
            return;
        Tile tile = getQsTile();
        if (AudioEnhancerService.du.isEnabled(getApplicationContext())) {
            AudioEnhancerService.du.setEnabled(getApplicationContext(), false);
            tile.setState(Tile.STATE_INACTIVE);
        } else {
            AudioEnhancerService.du.setEnabled(getApplicationContext(), true);
            tile.setState(Tile.STATE_ACTIVE);
        }
        tile.updateTile();
        super.onClick();
    }
}
