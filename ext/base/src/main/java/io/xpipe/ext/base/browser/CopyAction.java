package io.xpipe.ext.base.browser;

import io.xpipe.app.browser.BrowserClipboard;
import io.xpipe.app.browser.BrowserEntry;
import io.xpipe.app.browser.OpenFileSystemModel;
import io.xpipe.app.browser.action.LeafAction;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.List;

public class CopyAction implements LeafAction {

    @Override
    public void execute(OpenFileSystemModel model, List<BrowserEntry> entries) {
        BrowserClipboard.startCopy(
                model.getCurrentDirectory(),
                entries.stream().map(entry -> entry.getRawFileEntry()).toList());
    }

    @Override
    public boolean acceptsEmptySelection() {
        return true;
    }

    @Override
    public Node getIcon(OpenFileSystemModel model, List<BrowserEntry> entries) {
        return new FontIcon("mdi2c-content-copy");
    }

    @Override
    public Category getCategory() {
        return Category.COPY_PASTE;
    }

    @Override
    public KeyCombination getShortcut() {
        return new KeyCodeCombination(KeyCode.C, KeyCombination.SHORTCUT_DOWN);
    }

    @Override
    public String getName(OpenFileSystemModel model, List<BrowserEntry> entries) {
        return "Copy";
    }
}
