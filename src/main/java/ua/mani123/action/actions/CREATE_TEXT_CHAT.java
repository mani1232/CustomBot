package ua.mani123.action.actions;

import ua.mani123.action.Action;

public class CREATE_TEXT_CHAT implements Action {
    @Override
    public String getId() {
        return null;
    }

    @Override
    public boolean isOnlyCommand() {
        return false;
    }

    @Override
    public boolean isOnlyTicket() {
        return false;
    }
}
