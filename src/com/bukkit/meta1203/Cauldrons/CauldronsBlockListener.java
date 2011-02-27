package com.bukkit.meta1203.Cauldrons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.Material;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockRightClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.*;

import com.sun.tools.javac.code.Attribute.Array;
import com.sun.tools.javac.util.List;

/**
 * Cauldrons block listener
 * @author meta1203
 */
public class CauldronsBlockListener extends BlockListener {
    private final Cauldrons plugin;

    public CauldronsBlockListener(final Cauldrons plugin) {
        this.plugin = plugin;
    }

    //put all Block related code here
    public void onBlockRightClick (BlockRightClickEvent event) {
    	ItemStack inHand = event.getItemInHand();
    	if (inHand.getType() == Material.STICK) {
    		test(event.getBlock());
    	}
    }
    private void test(Block block) {
    	Block[][][] whole = new Block[4][4][3];
    	Block[][][] in = new Block[2][2][3];
    	if (block.getRelative(0, -1, 0).getTypeId()==10 || block.getRelative(0, -2, 0).getTypeId()==10) {
    		if ((block.getRelative(BlockFace.EAST).getTypeId()==1) || (block.getRelative(BlockFace.NORTH).getTypeId()==1) ||(block.getRelative(BlockFace.SOUTH).getTypeId()==1) || (block.getRelative(BlockFace.WEST).getTypeId()==1)) {
    			// loopdeloop
    			Block current = block;
    			boolean eastFound = false;
    			boolean bottomFound = false;
    			boolean northFound = false;
    			int count = 0;
    			while ((!eastFound) && (!bottomFound) && (!northFound) && (count < 3)) {
    				if (!eastFound) {
    					current = current.getRelative(BlockFace.EAST);
    					if (current.getTypeId() == 1) {
    						eastFound = true;
    					}
    				}
    				if (!northFound) {
    					current = current.getRelative(BlockFace.NORTH);
    					if (current.getTypeId() == 1) {
    						northFound = true;
    					}
    				}
    				if (!bottomFound) {
    					current = current.getRelative(BlockFace.DOWN);
    					if (current.getTypeId() == 1) {
    						bottomFound = true;
    					}
    				}
    			}
    			whole[0][0][0] = current;
    			for (int z = 0; z < 3; z++) {
    			for (int x = 0; x < 4; x++) {
    				for (int y = 0; y < 4; y ++) {
    					whole[x][z][y] = current.getRelative(x, z, y);
    				}
    			}
    			}
    			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    			ArrayList<Block> list = new ArrayList<Block>();
    			for (int z = 0; z < 3; z++) {
        			for (int x = 0; x < 2; x++) {
        				for (int y = 0; y < 2; y ++) {
        					list.add(whole[x+1][z][y+1]);
        				}
        			}
        			}
    			
    			for (int x = 0; x<list.size(); x++) {
    				if (map.containsKey(list.get(1).getTypeId())) {
    					int val = map.get(list.get(1).getTypeId());
    					map.remove(list.get(1).getTypeId());
    					map.put(list.get(1).getTypeId(), val+1);
    					list.remove(1);
    				}
    				else {
    					map.put(list.get(1).getTypeId(), 1);
    					list.remove(1);
    				}
    				
    			}
    			
    			
    			
    		}
    	}
    }
    
    
}
