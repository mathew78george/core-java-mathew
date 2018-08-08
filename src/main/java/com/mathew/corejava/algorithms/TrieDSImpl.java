package com.mathew.corejava.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TrieDSImpl {

	public static void main(String[] args) {
		TrieImpl tree = new TrieImpl();
		tree.addWord("world");
	    tree.addWord("work");
	    tree.addWord("wolf");
	    tree.addWord("life");
	    tree.addWord("love");
	    tree.addWord("This is Mathew george");
	    tree.addWord("wood");
	    tree.addWord("wonder");
	    System.out.println(tree.getWordsForPrefix("wo"));
	}

}

class TrieNode {
	private final char ch;

	/**
	 * Flag indicates that this node is the end of the string.
	 */
	private boolean end;

	private LinkedList<TrieNode> children;

	public TrieNode(char ch) {
		this.ch = ch;
	}

	public void addChild(TrieNode node) {
		if (children == null) {
			children = new LinkedList<TrieNode>();
		}
		children.add(node);
	}

	public TrieNode getNode(char ch) {
		if (children == null) {
			return null;
		}
		for (TrieNode child : children) {
			if (child.getChar() == ch) {
				return child;
			}
		}
		return null;
	}

	public char getChar() {
		return ch;
	}

	public List<TrieNode> getChildren() {
		if (this.children == null) {
			return Collections.emptyList();
		}
		return children;
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}
}

class TrieImpl {
	TrieNode root;

	public TrieImpl() {
		root = new TrieNode((char) 0);
	}

	public List<String> getWordsForPrefix(String prefix) {
		if (prefix.length() == 0) {
			return Collections.emptyList();
		}
		TrieNode node = getNodeForPrefix(root, prefix);
		if (node == null) {
			return Collections.emptyList();
		}
		List<LinkedList<Character>> chars = collectChars(node);
		List<String> words = new ArrayList<String>(chars.size());// new ArrayList< String >() (chars.size());
		for (LinkedList<Character> charList : chars) {
			words.add(combine(prefix.substring(0, prefix.length() - 1), charList));
		}
		return words;
	}

	private String combine(String prefix, List<Character> charList) {
		StringBuilder sb = new StringBuilder(prefix);
		for (Character character : charList) {
			sb.append(character);
		}
		return sb.toString();
	}

	private TrieNode getNodeForPrefix(TrieNode node, String prefix) {
		if (prefix.length() == 0) {
			return node;
		}
		TrieNode next = node.getNode(prefix.charAt(0));
		if (next == null) {
			return null;
		}
		return getNodeForPrefix(next, prefix.substring(1, prefix.length()));
	}

	private List<LinkedList<Character>> collectChars(TrieNode node) {
		List<LinkedList<Character>> chars = new ArrayList<LinkedList<Character>>();

		if (node.getChildren().size() == 0) {
			chars.add(new LinkedList<Character>(Collections.singletonList(node.getChar())));
		} else {
			if (node.isEnd()) {
				chars.add(new LinkedList<Character>(Collections.singletonList(node.getChar())));
			}
			List<TrieNode> children = node.getChildren();
			for (TrieNode child : children) {
				List<LinkedList<Character>> childList = collectChars(child);
				for (LinkedList<Character> characters : childList) {
					characters.push(node.getChar());
					chars.add(characters);
				}
			}
		}
		return chars;
	}

	public void addWord(String word) {
		addWord(root, word);
	}

	private void addWord(TrieNode parent, String word) {
		if (word.trim().length() == 0) {
			return;
		}
		TrieNode child = parent.getNode(word.charAt(0));
		if (child == null) {
			child = new TrieNode(word.charAt(0));
			parent.addChild(child);
		}
		if (word.length() == 1) {
			child.setEnd(true);
		} else {
			addWord(child, word.substring(1, word.length()));
		}
	}

}