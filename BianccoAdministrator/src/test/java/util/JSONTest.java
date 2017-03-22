/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package util;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.biancco.admin.app.util.JSONUtil;
import com.biancco.admin.model.view.Node;

/**
 * JSON test.
 * 
 * @author SOSExcellence.
 */
public class JSONTest {
	@Test
	public void getJSONFromObject() {
		try {
			Node node = new Node();
			node.setText("Parent");
			node.setHref("2");
			node.setIcon("glyphicon glyphicon-folder-close");
			node.setSelectedIcon("glyphicon glyphicon-folder-open");
			node.setTags("");
			List<Node> nodes = new ArrayList<Node>();
			for (int i = 0; i < 5; i++) {
				Node n1 = new Node();
				n1.setText("Folder " + (i + 1));
				n1.setHref("2");
				n1.setIcon("glyphicon glyphicon-folder-close");
				n1.setSelectedIcon("glyphicon glyphicon-folder-open");
				n1.setTags("");
				nodes.add(n1);
			}
			node.setNodes(nodes);

			System.out.println(JSONUtil.getJSONString(node));

			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}

	}

}
