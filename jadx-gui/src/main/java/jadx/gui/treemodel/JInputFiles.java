package jadx.gui.treemodel;

import java.nio.file.Path;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

import jadx.gui.ui.MainWindow;
import jadx.gui.utils.NLS;
import jadx.gui.utils.UiUtils;
import jadx.gui.utils.ui.SimpleMenuItem;

public class JInputFiles extends JNode {
	private static final ImageIcon INPUT_FILES_ICON = UiUtils.openSvgIcon("nodes/moduleDirectory");

	public JInputFiles(List<Path> files) {
		for (Path file : files) {
			String fileName = file.getFileName().toString();
			if (fileName.endsWith(".smali")) {
				add(new JInputSmaliFile(file));
			} else {
				add(new JInputFile(file));
			}
		}
	}

	@Override
	public JPopupMenu onTreePopupMenu(MainWindow mainWindow) {
		JPopupMenu menu = new JPopupMenu();
		menu.add(new SimpleMenuItem(NLS.str("popup.add_files"), mainWindow::addFiles));
		return menu;
	}

	@Override
	public JClass getJParent() {
		return null;
	}

	@Override
	public Icon getIcon() {
		return INPUT_FILES_ICON;
	}

	@Override
	public String getID() {
		return "JInputFiles";
	}

	@Override
	public String makeString() {
		return NLS.str("tree.input_files");
	}
}
