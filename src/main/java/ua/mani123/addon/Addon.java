package ua.mani123.addon;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import ua.mani123.discord.action.Action;

public interface Addon {

  default void enable() {
  }

  default void disable() {
  }

  default void reload() {
  }

  /**
   * Method for add custom actions
   *
   * @param type   type of action (UpperCase)
   * @param key    id of action
   * @param config file for get data from configs
   */
  default Action addCustomAction(String type, String key, CommentedFileConfig config) {
    /**
     * Example
     *     switch (type) {
     *       case "MY_CUSTOM_ACTION" -> {
     *         return new BAN_USER(config);
     *       }
     *     }
     */


    return null;
  }
}
