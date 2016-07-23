package me.lucko.luckperms.commands.user.subcommands;

import me.lucko.luckperms.LuckPermsPlugin;
import me.lucko.luckperms.commands.Sender;
import me.lucko.luckperms.commands.Util;
import me.lucko.luckperms.commands.user.UserSubCommand;
import me.lucko.luckperms.constants.Message;
import me.lucko.luckperms.constants.Permission;
import me.lucko.luckperms.users.User;

import java.util.List;

public class UserListNodes extends UserSubCommand {
    public UserListNodes() {
        super("listnodes", "Lists the permission nodes the user has", "/%s user <user> listnodes", Permission.USER_LISTNODES);
    }

    @Override
    protected void execute(LuckPermsPlugin plugin, Sender sender, User user, List<String> args, String label) {
        Message.LISTNODES.send(sender, user.getName(), Util.permNodesToString(user.getPermanentNodes()));
        Message.LISTNODES_TEMP.send(sender, user.getName(), Util.tempNodesToString(user.getTemporaryNodes()));
    }

    @Override
    public boolean isArgLengthInvalid(int argLength) {
        return false;
    }
}