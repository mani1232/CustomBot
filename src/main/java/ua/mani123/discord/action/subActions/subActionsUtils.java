package ua.mani123.discord.action.subActions;

import com.electronwill.nightconfig.core.CommentedConfig;
import java.util.ArrayList;
import java.util.List;
import ua.mani123.discord.action.subActions.SActions.ADD_BUTTON;

public class subActionsUtils {

  public static ArrayList<SubAction> enable(List<CommentedConfig> config) {
    ArrayList<SubAction> subActions = new ArrayList<>();
    if (!config.isEmpty()) {
      for (CommentedConfig subActionCfg : config) {
        String type = subActionCfg.get("type");
        if (type.trim().equalsIgnoreCase("ADD-BUTTON")) {
          subActions.add(new ADD_BUTTON(subActionCfg));
        }
      }
    }
    return subActions;
  }

}
