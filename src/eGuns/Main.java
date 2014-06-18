/**
 * 
 */
/**
 * @author youuw
 *
 */
package eGuns;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import eGuns.Listenery.Amunicja;
import eGuns.Listenery.onEntityDamageByEntity;
import eGuns.Listenery.onPlayerInteract;
import eGuns.Komendy.bronie;

public class Main extends JavaPlugin {

	public static FileConfiguration cfg;
	public final Logger logger = Logger.getLogger("eGuns");
    public Map<String, Map<Projectile, Amunicja>> nabojeMap = new HashMap<>();
	public ArrayList<String> loreM9 = new ArrayList<String>();
	public ArrayList<String> loreSG = new ArrayList<String>();
	public ArrayList<String> loreM14 = new ArrayList<String>();
	public ArrayList<String> loreM16 = new ArrayList<String>();
	public ArrayList<String> loreAK47 = new ArrayList<String>();
	public String nameM9 = ChatColor.GOLD + " --=M9=-- ";
	public String nameSG = ChatColor.GOLD + " --=Shout Gun=-- ";
	public String nameM14 = ChatColor.GOLD + " --=M14=-- ";
	public String nameM16 = ChatColor.GOLD + " --=M16=-- ";
	public String nameAK47 = ChatColor.GOLD + " --=AK-47=-- ";
	
	@Override
	public void onEnable() {
		File file = new File(getDataFolder() + File.separator + "config.yml");
		if (!file.exists()) {
			this.getLogger().info("Generowanie config.yml...");
			this.getConfig().options().copyDefaults(true);
			this.saveConfig();
		} else {
			this.saveConfig();
		}

		cfg = getConfig();

		getCommand("bronie").setExecutor(new bronie(this));

		// M9 1
		ItemStack M9 = new ItemStack(Material.WOOD_HOE);
		ItemMeta MetaItemM9 = M9.getItemMeta();
		MetaItemM9.setDisplayName(nameM9);
		loreM9.add(ChatColor.AQUA + "Zwykła broń ");
		loreM9.add(ChatColor.AQUA + "Jedno naciśnięcie - 1 pocisk ");
		loreM9.add(ChatColor.AQUA + "Przytrzymanie PPM nic nie da ");
		loreM9.add(ChatColor.AQUA
				+ "Amunicja do kupienia w naszym ItemShopie! ");
		MetaItemM9.setLore(loreM9);
		MetaItemM9.addEnchant(Enchantment.DURABILITY, 10, true);
		MetaItemM9.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		M9.setItemMeta(MetaItemM9);
		ShapedRecipe RecipeM9 = new ShapedRecipe(M9);
		RecipeM9.shape("GGG", "GGG", "GGG");
		RecipeM9.setIngredient('G', Material.DIRT);
		Bukkit.getServer().addRecipe(RecipeM9);
		M9.setAmount(1);

		// SHoutGun 2
		ItemStack SG = new ItemStack(Material.STONE_HOE);
		ItemMeta MetaItemSG = SG.getItemMeta();
		MetaItemSG.setDisplayName(nameSG);
		loreSG.add(ChatColor.AQUA + "ShoutGun ");
		loreSG.add(ChatColor.AQUA + "Jedno naciśnięcie - 1 pocisk ");
		loreSG.add(ChatColor.AQUA + "Przytrzymanie PPM nic nie da ");
		loreSG.add(ChatColor.AQUA
				+ "Amunicja do kupienia w naszym ItemShopie! ");
		MetaItemSG.setLore(loreSG);
		MetaItemSG.addEnchant(Enchantment.DURABILITY, 10, true);
		MetaItemSG.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		SG.setItemMeta(MetaItemSG);
		ShapedRecipe RecipeSG = new ShapedRecipe(SG);
		RecipeSG.shape("GGG", "GGG", "GGG");
		RecipeSG.setIngredient('G', Material.IRON_BLOCK);
		Bukkit.getServer().addRecipe(RecipeSG);
		SG.setAmount(1);

		// M14 3
		ItemStack M14 = new ItemStack(Material.IRON_HOE);
		ItemMeta MetaItemM14 = M14.getItemMeta();
		MetaItemM14.setDisplayName(nameM14);
		loreM14.add(ChatColor.AQUA + "Broń snajperska ");
		loreM14.add(ChatColor.AQUA + "Jedno naciśnięcie - 1 pocisk ");
		loreM14.add(ChatColor.AQUA + "Przytrzymanie PPM nic nie da ");
		loreM14.add(ChatColor.AQUA
				+ "Amunicja do kupienia w naszym ItemShopie! ");
		MetaItemM14.setLore(loreM14);
		MetaItemM14.addEnchant(Enchantment.DURABILITY, 10, true);
		MetaItemM14.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		M14.setItemMeta(MetaItemM14);
		ShapedRecipe RecipeM14 = new ShapedRecipe(M14);
		RecipeM14.shape("GGG", "GGG", "GGG");
		RecipeM14.setIngredient('G', Material.GOLD_BLOCK);
		Bukkit.getServer().addRecipe(RecipeM14);
		M14.setAmount(1);

		// M16 4
		ItemStack M16 = new ItemStack(Material.GOLD_HOE);
		ItemMeta MetaItemM16 = M16.getItemMeta();
		MetaItemM16.setDisplayName(nameM16);
		loreM16.add(ChatColor.AQUA + "Karabin maszynowy ");
		loreM16.add(ChatColor.AQUA + "Jedno naciśnięcie - 2 pociski ");
		loreM16.add(ChatColor.AQUA
				+ "Przytrzymanie PPM uruchamia serię strzałów ");
		loreM16.add(ChatColor.AQUA
				+ "Amunicja do kupienia w naszym ItemShopie! ");
		MetaItemM16.setLore(loreM16);
		MetaItemM16.addEnchant(Enchantment.DURABILITY, 10, true);
		MetaItemM16.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		M16.setItemMeta(MetaItemM16);
		ShapedRecipe RecipeM16 = new ShapedRecipe(M16);
		RecipeM16.shape("GGG", "GGG", "GGG");
		RecipeM16.setIngredient('G', Material.DIAMOND_BLOCK);
		Bukkit.getServer().addRecipe(RecipeM16);
		M16.setAmount(1);

		// AK47 5
		ItemStack AK47 = new ItemStack(Material.DIAMOND_HOE);
		ItemMeta MetaItemAK47 = AK47.getItemMeta();
		MetaItemAK47.setDisplayName(nameAK47);
		loreAK47.add(ChatColor.AQUA + "Broń maszynowa ");
		loreAK47.add(ChatColor.AQUA + "Jedno naciśnięcie - 3 pociski ");
		loreAK47.add(ChatColor.AQUA
				+ "Przytrzymanie PPM uruchamia serię strzałów ");
		loreAK47.add(ChatColor.AQUA
				+ "Amunicja do kupienia w naszym ItemShopie! ");
		MetaItemAK47.setLore(loreAK47);
		MetaItemAK47.addEnchant(Enchantment.DURABILITY, 10, true);
		MetaItemAK47.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		AK47.setItemMeta(MetaItemAK47);
		ShapedRecipe RecipeAK47 = new ShapedRecipe(AK47);
		RecipeAK47.shape("GGG", "GGG", "GGG");
		RecipeAK47.setIngredient('G', Material.GOLD_SWORD);
		Bukkit.getServer().addRecipe(RecipeAK47);
		AK47.setAmount(1);

		// amoAK47 6
		ItemStack amoAK47 = new ItemStack(Material.SNOW_BALL);
		ItemMeta amoMetaItemAK47 = amoAK47.getItemMeta();
		amoMetaItemAK47.setDisplayName(ChatColor.GOLD
				+ " --=Amunicja do AK-47=-- ");
		amoMetaItemAK47.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
		amoAK47.setItemMeta(amoMetaItemAK47);
		ShapedRecipe amoRecipeAK47 = new ShapedRecipe(amoAK47);
		amoRecipeAK47.shape("SSS", "SGS", "SSS");
		amoRecipeAK47.setIngredient('G', Material.DIAMOND_SWORD);
		amoRecipeAK47.setIngredient('S', Material.SNOW_BALL);
		Bukkit.getServer().addRecipe(amoRecipeAK47);
		amoAK47.setAmount(16);

		// amoM16 7
		ItemStack amoM16 = new ItemStack(Material.SNOW_BALL);
		ItemMeta amoMetaItemM16 = amoM16.getItemMeta();
		amoMetaItemM16.setDisplayName(ChatColor.GOLD
				+ " --=Amunicja do M16=-- ");
		amoMetaItemM16.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
		amoM16.setItemMeta(amoMetaItemM16);
		ShapedRecipe amoRecipeM16 = new ShapedRecipe(amoM16);
		amoRecipeM16.shape("SSS", "SGS", "SSS");
		amoRecipeM16.setIngredient('G', Material.GOLD_SWORD);
		amoRecipeM16.setIngredient('S', Material.SNOW_BALL);
		Bukkit.getServer().addRecipe(amoRecipeM16);
		amoM16.setAmount(16);

		// amoM14 8
		ItemStack amoM14 = new ItemStack(Material.SNOW_BALL);
		ItemMeta amoMetaItemM14 = amoM14.getItemMeta();
		amoMetaItemM14.setDisplayName(ChatColor.GOLD
				+ " --=Amunicja do M14=-- ");
		amoMetaItemM14.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
		amoM14.setItemMeta(amoMetaItemM14);
		ShapedRecipe amoRecipeM14 = new ShapedRecipe(amoM14);
		amoRecipeM14.shape("SSS", "SGS", "SSS");
		amoRecipeM14.setIngredient('G', Material.IRON_SWORD);
		amoRecipeM14.setIngredient('S', Material.SNOW_BALL);
		Bukkit.getServer().addRecipe(amoRecipeM14);
		amoM14.setAmount(16);

		// amoShoutGun 9
		ItemStack amoSG = new ItemStack(Material.SNOW_BALL);
		ItemMeta amoMetaItemSG = amoSG.getItemMeta();
		amoMetaItemSG.setDisplayName(ChatColor.GOLD
				+ " --=Amunicja do Shout Gun'a=-- ");
		amoMetaItemSG.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
		amoSG.setItemMeta(amoMetaItemSG);
		ShapedRecipe amoRecipeSG = new ShapedRecipe(amoSG);
		amoRecipeSG.shape("SSS", "SGS", "SSS");
		amoRecipeSG.setIngredient('G', Material.STONE_SWORD);
		amoRecipeSG.setIngredient('S', Material.SNOW_BALL);
		Bukkit.getServer().addRecipe(amoRecipeSG);
		amoSG.setAmount(16);

		// amoM9 10
		ItemStack amoM9 = new ItemStack(Material.SNOW_BALL);
		ItemMeta amoMetaItemM9 = amoM9.getItemMeta();
		amoMetaItemM9.setDisplayName(ChatColor.GOLD + " --=Amunicja do M9=-- ");
		amoMetaItemM9.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
		amoM9.setItemMeta(amoMetaItemM9);
		ShapedRecipe amoRecipeM9 = new ShapedRecipe(amoM9);
		amoRecipeM9.shape("SSS", "SGS", "SSS");
		amoRecipeM9.setIngredient('G', Material.WOOD_SWORD);
		amoRecipeM9.setIngredient('S', Material.SNOW_BALL);
		Bukkit.getServer().addRecipe(amoRecipeM9);
		amoM9.setAmount(16);

		this.getServer().getPluginManager()
		.registerEvents(new onEntityDamageByEntity(this), this);
		this.getServer().getPluginManager()
		.registerEvents(new onPlayerInteract(this), this);
	}

}
