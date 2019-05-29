package com.aor.ghostrumble.menu.event;

import com.aor.ghostrumble.menu.model.MenuModel;

public class NullEvent implements MenuEvent {

    @Override
    public boolean process(MenuModel model) {
        return false;
    }

}
