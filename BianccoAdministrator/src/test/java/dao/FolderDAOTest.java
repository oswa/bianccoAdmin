/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.junit.Test;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.folder.FolderDocument;
import com.biancco.admin.model.view.Node;
import com.biancco.admin.persistence.dao.FolderDAO;
import com.biancco.admin.persistence.model.FolderBase;
import com.biancco.admin.persistence.model.FolderType;

/**
 * Folder DAO test.
 * 
 * @author SOSExcellence.
 */
public class FolderDAOTest extends DAOTest {
	// @Test
	public void insert() {
		final FolderDAO dao = (FolderDAO) applicationContext.getBean(FolderDAO.class);
		try {
			// employee structure
			this.insertEmployeeFolders(dao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void get() {
		final FolderDAO dao = (FolderDAO) applicationContext.getBean(FolderDAO.class);
		try {
			// List<FolderBase> folders =
			// dao.getFolderBaseByType(FolderType.EMPLOYEE);
			List<FolderDocument> folder = dao.getFolderDocumentsByType(FolderType.EMPLOYEE, 9L);
			System.out.println(ReflectionToStringBuilder.toString(folder));
			Node n = buildTreeFolder(folder);
			System.out.println("root -> " + n.getText());
			printTree(n.getNodes(), "-");

			/*
			 * for (FolderBase f : folders) {
			 * System.out.println(f.getPathChild()); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Node buildTreeFolder(List<FolderDocument> folder) {
		// get root
		FolderDocument root = folder.get(0);
		Node node = new Node();
		node.setText(root.getPathChild());
		// clean folder
		folder.remove(0);
		// get parent
		Long parent = root.getIdFolder();
		// set childs to root
		List<Node> childs = this.extractNodesByParent(folder, parent);
		node.setNodes(childs);

		return node;
	}

	private List<Node> extractNodesByParent(List<FolderDocument> folder, final Long parent) {
		// select items
		List<FolderDocument> selectedItems = this.selectFoldersByParent(folder, parent);
		// initialize nodes
		List<Node> nodes = new ArrayList<Node>();
		// evaluate items
		Node node = null;
		int totalDocs = 0;
		for (FolderDocument fd : selectedItems) {
			// create a folder node
			if (node == null) {
				node = new Node();
				node.setText(fd.getPathChild());
				// add node
				nodes.add(node);
				// set childs if contains
				Long nodeParent = fd.getIdFolder();
				List<Node> childs = this.extractNodesByParent(folder, nodeParent);
				if (!childs.isEmpty()) {
					node.setNodes(childs);
				}
			}
			// validate if contains a document
			Long idDoc = fd.getIdDocument();
			if (idDoc != null) {
				// create a document node
				Node child = new Node();
				child.setText(fd.getName());
				// add child
				node.addNode(child);
				// count docs
				totalDocs++;
				node.setTags(new Integer[] { totalDocs });
			} else {
				// reset node
				node = null;
				// reset counter
				totalDocs = 0;
			}
		}
		return nodes;
	}

	@SuppressWarnings("unchecked")
	private List<FolderDocument> selectFoldersByParent(List<FolderDocument> folder, final Long parent) {
		// select items by parent
		Predicate p = new Predicate() {

			@Override
			public boolean evaluate(final Object o) {
				FolderDocument fd = (FolderDocument) o;
				return fd.getParent() == parent;
			}
		};
		return (List<FolderDocument>) CollectionUtils.select(folder, p);
	}

	private void printTree(List<Node> nodes, String depth) {
		for (Node n : nodes) {
			System.out.println(depth + n.getText());
			if (n.getNodes() != null) {
				printTree(n.getNodes(), depth + "-");
			}
		}
	}

	/**
	 * Creates the employee folder structure.
	 * 
	 * @param dao
	 *            Folder DAO.
	 * @throws DBException
	 *             If a db excpetion is thrown.
	 */
	private void insertEmployeeFolders(FolderDAO dao) throws DBException {
		// root
		FolderBase f1 = new FolderBase();
		f1.setAllowModify(false);
		f1.setPathRoot("C:\\BIANCCO");
		f1.setPathChild("EMPLEADOS");
		f1.setPatterns("");
		f1.setType(FolderType.EMPLOYEE);
		f1 = dao.save(f1);

		// Path root
		String root = f1.getPathRoot() + File.separator + f1.getPathChild();
		// Parent
		long idParent = f1.getIdFolder();

		// RFC
		FolderBase f = new FolderBase();
		f.setAllowModify(false);
		f.setPathRoot(root);
		f.setPathChild("RFC");
		f.setPatterns("");
		f.setParent(idParent);
		f.setType(FolderType.EMPLOYEE);
		dao.save(f);
		// CURP
		f = new FolderBase();
		f.setAllowModify(false);
		f.setPathRoot(root);
		f.setPathChild("CURP");
		f.setPatterns("");
		f.setParent(idParent);
		f.setType(FolderType.EMPLOYEE);
		dao.save(f);
		// CURRICULUM
		f = new FolderBase();
		f.setAllowModify(false);
		f.setPathRoot(root);
		f.setPathChild("CURRICULUM");
		f.setPatterns("");
		f.setParent(idParent);
		f.setType(FolderType.EMPLOYEE);
		dao.save(f);
		// CEDULA
		f = new FolderBase();
		f.setAllowModify(false);
		f.setPathRoot(root);
		f.setPathChild("CEDULA");
		f.setPatterns("");
		f.setParent(idParent);
		f.setType(FolderType.EMPLOYEE);
		dao.save(f);
		// TITULO
		f = new FolderBase();
		f.setAllowModify(false);
		f.setPathRoot(root);
		f.setPathChild("TITULO");
		f.setPatterns("");
		f.setParent(idParent);
		f.setType(FolderType.EMPLOYEE);
		dao.save(f);
		// IFE
		f = new FolderBase();
		f.setAllowModify(false);
		f.setPathRoot(root);
		f.setPathChild("IFE");
		f.setPatterns("");
		f.setParent(idParent);
		f.setType(FolderType.EMPLOYEE);
		dao.save(f);
		// CERTIFICADO DE SUPERINTENDENTE
		f = new FolderBase();
		f.setAllowModify(false);
		f.setPathRoot(root);
		f.setPathChild("CERTIFICADO DE SUPERINTENDENTE");
		f.setPatterns("");
		f.setParent(idParent);
		f.setType(FolderType.EMPLOYEE);
		dao.save(f);
		// CERTIFICADO DE PRECIOS UNITARIOS
		f = new FolderBase();
		f.setAllowModify(false);
		f.setPathRoot(root);
		f.setPathChild("CERTIFICADO DE PRECIOS UNITARIOS");
		f.setPatterns("");
		f.setParent(idParent);
		f.setType(FolderType.EMPLOYEE);
		dao.save(f);
		// COMPROBANTE DE DOMICILIO
		f = new FolderBase();
		f.setAllowModify(false);
		f.setPathRoot(root);
		f.setPathChild("COMPROBANTE DE DOMICILIO");
		f.setPatterns("");
		f.setParent(idParent);
		f.setType(FolderType.EMPLOYEE);
		dao.save(f);
		// FIRMA
		f = new FolderBase();
		f.setAllowModify(false);
		f.setPathRoot(root);
		f.setPathChild("FIRMA");
		f.setPatterns("");
		f.setParent(idParent);
		f.setType(FolderType.EMPLOYEE);
		dao.save(f);
		// FOTOS
		f = new FolderBase();
		f.setAllowModify(false);
		f.setPathRoot(root);
		f.setPathChild("FOTOS");
		f.setPatterns("");
		f.setParent(idParent);
		f.setType(FolderType.EMPLOYEE);
		dao.save(f);
		// CERTIFICADOS VARIOS
		f = new FolderBase();
		f.setAllowModify(false);
		f.setPathRoot(root);
		f.setPathChild("CERTIFICADOS VARIOS");
		f.setPatterns("");
		f.setParent(idParent);
		f.setType(FolderType.EMPLOYEE);
		dao.save(f);
		// FIRMA ELECTRONICA
		f = new FolderBase();
		f.setAllowModify(false);
		f.setPathRoot(root);
		f.setPathChild("FIRMA ELECTRONICA");
		f.setPatterns("");
		f.setParent(idParent);
		f.setType(FolderType.EMPLOYEE);
		dao.save(f);
	}
}
