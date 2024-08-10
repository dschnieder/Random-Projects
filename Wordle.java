import java.util.Random;
import java.util.Scanner;

public class Wordle {
    static String ANSI_RESET = "\u001B[0m";
    static String ANSI_GREEN = "\u001B[32m";
    static String ANSI_YELLOW = "\u001B[33m";
    
    static String[] words = {"ABACK", "ABASE", "ABATE", "ABBEY", "ABIDE", "ABOUT", "ABOVE", "ABYSS", "ACRID", "ACTOR", "ACUTE", "ADAGE", "ADAPT", "ADMIT", "ADOBE", "ADOPT", "ADORE", "ADULT", "AFTER", "AGAIN", "AGAPE", "AGATE", "AGENT", "AGILE", "AGING", "AGLOW", "AGONY", "AGREE", "AHEAD", "ALBUM", "ALIEN", "ALIKE", "ALIVE", "ALLOW", "ALOFT", "ALONE", "ALOOF", "ALOUD", "ALPHA", "ALTAR", "ALTER", "AMASS", "AMBER", "AMISS", "AMPLE", "ANGEL", "ANGER", "ANGRY", "ANGST", "ANODE", "ANTIC", "ANVIL", "AORTA", "APART", "APHID", "APPLE", "APPLY", "APRON", "APTLY", "ARBOR", "ARDOR", "ARGUE", "AROMA", "ASCOT", "ASIDE", "ASKEW", "ASSET", "ATOLL", "ATONE", "AUDIO", "AUDIT", "AVAIL", "AVERT", "AWAIT", "AWAKE", "AWASH", "AWFUL", "AXIOM", "AZURE", "BACON", "BADGE", "BADLY", "BAGEL", "BAKER", "BALSA", "BANAL", "BARGE", "BASIC", "BASIN", "BATHE", "BATON", "BATTY", "BAYOU", "BEACH", "BEADY", "BEAST", "BEEFY", "BEGET", "BEGIN", "BEING", "BELCH", "BELIE", "BELLY", "BELOW", "BENCH", "BERET", "BERTH", "BESET", "BEVEL", "BINGE", "BIOME", "BIRCH", "BIRTH", "BLACK", "BLAME", "BLAND", "BLARE", "BLEAK", "BLEED", "BLEEP", "BLIMP", "BLOCK", "BLOKE", "BLOND", "BLOWN", "BLUFF", "BLURB", "BLURT", "BLUSH", "BOOBY", "BOOST", "BOOZE", "BOOZY", "BORAX", "BOUGH", "BRAID", "BRAKE", "BRASH", "BRAVE", "BRAVO", "BREAD", "BREAK", "BREED", "BRIAR", "BRIBE", "BRIDE", "BRIEF", "BRINE", "BRING", "BRINK", "BRINY", "BRISK", "BROKE", "BROOK", "BROOM", "BROTH", "BRUSH", "BUDDY", "BUGGY", "BUGLE", "BUILD", "BUILT", "BULKY", "BULLY", "BUNCH", "BURLY", "CABLE", "CACAO", "CACHE", "CADET", "CAMEO", "CANDY", "CANNY", "CANOE", "CANON", "CAPER", "CARAT", "CARGO", "CAROL", "CARRY", "CATCH", "CATER", "CAULK", "CAUSE", "CEDAR", "CHAFE", "CHAIN", "CHALK", "CHAMP", "CHANT", "CHAOS", "CHARD", "CHARM", "CHART", "CHEAT", "CHEEK", "CHEER", "CHEST", "CHIEF", "CHILD", "CHILL", "CHIME", "CHOIR", "CHOKE", "CHORD", "CHUNK", "CHUTE", "CIDER", "CIGAR", "CINCH", "CIRCA", "CIVIC", "CLASS", "CLEAN", "CLEAR", "CLEFT", "CLERK", "CLICK", "CLIMB", "CLING", "CLOCK", "CLONE", "CLOSE", "CLOTH", "CLOWN", "CLUCK", "COACH", "COAST", "COCOA", "COLON", "COMET", "COMMA", "CONDO", "CONIC", "CORNY", "COULD", "COUNT", "COURT", "COVER", "COVET", "COWER", "COYLY", "CRAFT", "CRAMP", "CRANE", "CRANK", "CRASS", "CRATE", "CRAVE", "CRAZE", "CRAZY", "CREAK", "CREDO", "CREPT", "CRIME", "CRIMP", "CROAK", "CRONE", "CROSS", "CROWD", "CRUMB", "CRUSH", "CRUST", "CUMIN", "CURLY", "CYNIC", "DADDY", "DAISY", "DANCE", "DANDY", "DEATH", "DEBUG", "DEBUT", "DECAY", "DECAL", "DECOY", "DELTA", "DELVE", "DENIM", "DEPOT", "DEPTH", "DETER", "DEVIL", "DIARY", "DIGIT", "DINER", "DINGO", "DISCO", "DITTO", "DODGE", "DOING", "DOLLY", "DONOR", "DONUT", "DOUBT", "DOWRY", "DOZEN", "DRAIN", "DREAM", "DRINK", "DRIVE", "DROLL", "DROOP", "DROVE", "DUCHY", "DUTCH", "DUVET", "DWARF", "DWELL", "DWELT", "EARLY", "EARTH", "EBONY", "EDICT", "EGRET", "EJECT", "ELDER", "ELOPE", "ELUDE", "EMAIL", "EMBER", "EMPTY", "ENACT", "ENEMA", "ENJOY", "ENNUI", "ENSUE", "ENTER", "EPOCH", "EPOXY", "EQUAL", "EQUIP", "ERODE", "ERROR", "ERUPT", "ESSAY", "ETHER", "ETHIC", "ETHOS", "EVADE", "EVERY", "EVOKE", "EXACT", "EXALT", "EXCEL", "EXERT", "EXIST", "EXPEL", "EXTRA", "EXULT", "FACET", "FARCE", "FAULT", "FAVOR", "FEAST", "FEIGN", "FERAL", "FERRY", "FEWER", "FIELD", "FIEND", "FIFTY", "FINAL", "FINCH", "FINER", "FIRST", "FISHY", "FIXER", "FJORD", "FLAIL", "FLAIR", "FLAKE", "FLAME", "FLANK", "FLARE", "FLASK", "FLESH", "FLICK", "FLING", "FLIRT", "FLOAT", "FLOCK", "FLOOD", "FLOOR", "FLORA", "FLOSS", "FLOUT", "FLUFF", "FLUME", "FLYER", "FOCAL", "FOCUS", "FOGGY", "FOLLY", "FORAY", "FORCE", "FORGE", "FORGO", "FORTE", "FORTH", "FORTY", "FOUND", "FOYER", "FRAME", "FRANK", "FRESH", "FRIED", "FROCK", "FROND", "FRONT", "FROST", "FROTH", "FROZE", "FUNGI", "FUNNY", "GAMER", "GAMMA", "GAUDY", "GAUNT", "GAUZE", "GAWKY", "GECKO", "GENRE", "GHOUL", "GIANT", "GIDDY", "GIRTH", "GIVEN", "GLASS", "GLAZE", "GLEAM", "GLEAN", "GLIDE", "GLOAT", "GLOBE", "GLOOM", "GLORY", "GLOVE", "GLYPH", "GNASH", "GOLEM", "GONER", "GOOSE", "GORGE", "GOUGE", "GRACE", "GRADE", "GRAIL", "GRAND", "GRAPH", "GRASP", "GRATE", "GREAT", "GREEN", "GREET", "GRIEF", "GRIME", "GRIMY", "GRIND", "GRIPE", "GROIN", "GROOM", "GROUP", "GROUT", "GROVE", "GROWL", "GRUEL", "GUANO", "GUARD", "GUEST", "GUIDE", "GUILD", "GULLY", "GUMMY", "GUPPY", "HAIRY", "HAPPY", "HATCH", "HATER", "HAVOC", "HEADY", "HEARD", "HEART", "HEATH", "HEAVE", "HEAVY", "HEIST", "HELIX", "HELLO", "HENCE",
         "HERON", "HINGE", "HITCH", "HOARD", "HOBBY", "HOMER", "HORDE", "HORSE", "HOTEL", "HOUND", "HOUSE", "HOWDY", "HUMAN", "HUMID", "HUMOR", "HUMPH", "HUNCH", "HUNKY", "HURRY", "HUTCH", "HYPER", "IGLOO", "IMAGE", "IMPEL", "INANE", "INDEX", "INEPT", "INERT", "INFER", "INLAY", "INPUT", "INTER", "INTRO", "IONIC", "IRATE", "IRONY", "ISLET", "ITCHY", "IVORY", "JAUNT", "JAZZY", "JERKY", "JIFFY", "JOKER", "JOLLY", "JOUST", "JUDGE", "JUICE", "KARMA", "KAYAK", "KAZOO", "KEBAB", "KHAKI", "KIOSK", "KNEAD", "KNEEL", "KNELT", "KNOCK", "KNOLL", "KOALA", "LABEL", "LABOR", "LAPEL", "LAPSE", "LARGE", "LARVA", "LASER", "LATTE", "LAYER", "LEAFY", "LEAKY", "LEAPT", "LEARN", "LEASH", "LEAVE", "LEDGE", "LEERY", "LEGGY", "LEMON", "LIBEL", "LIGHT", "LILAC", "LIMIT", "LINEN", "LINER", "LINGO", "LIVER", "LOCAL", "LOCUS", "LOFTY", "LOGIC", "LOOPY", "LOSER", "LOUSE", "LOVER", "LOWER", "LOWLY", "LOYAL", "LUCID", "LUCKY", "LUNAR", "LUNCH", "LUNGE", "LUSTY", "LYING", "MACAW", "MADAM", "MAGIC", "MAGMA", "MAIZE", "MAJOR", "MANIA", "MANGA", "MANLY", "MANOR", "MAPLE", "MARCH", "MARRY", "MARSH", "MASON", "MASSE", "MATCH", "MATEY", "MAXIM", "MAYBE", "MAYOR", "MEALY", "MEANT", "MEDAL", "MEDIA", "MELON", "MERCY", "MERGE", "MERIT", "MERRY", "METAL", "METRO", "MICRO", "MIDGE", "MIDST", "MIMIC", "MINCE", "MINUS", "MODEL", "MOIST", "MOLAR", "MONEY", "MONTH", "MOOSE", "MOSSY", "MOTOR", "MOTTO", "MOULT", "MOUNT", "MOURN", "MOUSE", "MOVIE", "MUCKY", "MUMMY", "MURAL", "MUSIC", "MUSTY", "NAIVE", "NANNY", "NASTY", "NATAL", "NAVAL", "NEEDY", "NERDY", "NEVER", "NICER", "NIGHT", "NINJA", "NINTH", "NOBLE", "NOISE", "NORTH", "NYMPH", "OCCUR", "OCEAN", "OFFAL", "OFTEN", "OLDER", "OLIVE", "ONION", "ONSET", "OPERA", "ORDER", "ORGAN", "OTHER", "OUGHT", "OUNCE", "OUTDO", "OUTER", "OVERT", "OXIDE", "PAINT", "PANEL", "PANIC", "PAPAL", "PAPER", "PARER", "PARRY", "PARTY", "PASTA", "PATTY", "PAUSE", "PEACE", "PEACH", "PENNE", "PERCH", "PERKY", "PESKY", "PHASE", "PHONE", "PHONY", "PHOTO", "PIANO", "PICKY", "PIETY", "PILOT", "PINCH", "PINEY", "PINKY", "PINTO", "PIOUS", "PIPER", "PIQUE", "PITHY", "PIXEL", "PIXIE", "PLACE", "PLAIT", "PLANK", "PLANT", "PLATE", "PLAZA", "PLEAT", "PLUCK", "PLUNK", "POINT", "POISE", "POKER", "POLKA", "POLYP", "PORCH", "POUND", "POWER", "PRICE", "PRICK", "PRIDE", "PRIME", "PRIMO", "PRINT", "PRIOR", "PRIZE", "PROBE", "PRONG", "PROUD", "PROVE", "PROWL", "PROXY", "PRUNE", "PSALM", "PULPY", "PURGE", "QUALM", "QUART", "QUEEN", "QUERY", "QUEST", "QUEUE", "QUICK", "QUIET", "QUIRK", "QUITE", "QUOTE", "RADIO", "RAINY", "RAISE", "RAMEN", "RANCH", "RANGE", "RATIO", "RAYON", "REACT", "REALM", "REBUS", "REBUT", "RECAP", "REFER", "REGAL", "RELIC", "RENEW", "REPAY", "REPEL", "RESIN", "RETCH", "RETRO", "RETRY", "REVEL", "RHINO", "RHYME", "RIDGE", "RIGHT", "RIPER", "RISEN", "RIVAL", "ROBIN", "ROBOT", "ROCKY", "RODEO", "ROGUE", "ROOMY", "ROUGE", "ROUND", "ROUSE", "ROUTE", "ROVER", "ROYAL", "RUDDY", "RUDER", "RUPEE", "RUSTY", "SAINT", "SALAD", "SALLY", "SALSA", "SALTY", "SASSY", "SAUCY", "SAUTE", "SAVOR", "SCALD", "SCALE", "SCANT", "SCARE", "SCARF", "SCENT", "SCOFF", "SCOLD", "SCOPE", "SCORN", "SCOUR", "SCOUT", "SCRAM", "SCRAP", "SCRUB", "SEDAN", "SEEDY", "SENSE", "SERUM", "SERVE", "SEVER", "SHADE", "SHAFT", "SHAKE", "SHALL", "SHAME", "SHANK", "SHAPE", "SHARD", "SHARP", "SHAVE", "SHAWL", "SHIFT", "SHINE", "SHIRE", "SHIRK", "SHORN", "SHOWN", "SHOWY", "SHRUB", "SHRUG", "SHYLY", "SIEGE", "SIGHT", "SINCE", "SISSY", "SKIER", "SKILL", "SKIMP", "SKIRT", "SKUNK", "SLATE", "SLEEK", "SLEEP", "SLICE", "SLOPE", "SLOSH", "SLOTH", "SLUMP", "SLUNG", "SMALL", "SMART", "SMASH", "SMEAR", "SMELT", "SMILE", "SMIRK", "SMITE", "SMITH", "SMOCK", "SNACK", "SNAFU", "SNAIL", "SNAKE", "SNAKY", "SNARE", "SNARL", "SNEAK", "SNORT", "SNOUT", "SOGGY", "SOLAR", "SOLID", "SOLVE", "SONIC", "SOUND", "SOWER", "SPACE", "SPADE", "SPEAK", "SPECK", "SPELL", "SPELT", "SPEND", "SPENT", "SPICE", "SPICY", "SPIEL", "SPIKE", "SPILL", "SPIRE", "SPLAT", "SPOKE", "SPRAY", "SPURT", "SQUAD", "SQUAT", "STAFF", "STAGE", "STAID", "STAIR", "STALE", "STALL", "STAND", "STARK", "START", "STASH", "STATE", "STEAD", "STEED", "STEEL", "STEIN", "STICK", "STIFF", "STILL", "STING", "STINK", "STOCK", "STOLE", "STOMP", "STONE", "STONY", "STOOL", "STORE", "STORY", "STOUT", "STOVE", "STRAP", "STRAW", "STUDY", "STUNG", "STYLE", "SUGAR", "SULKY", "SUPER", "SURER", "SURLY", "SUSHI", "SWEAT", "SWEEP", "SWEET", "SWILL", "SWINE", "SWIRL", "SWISH", "SWOON", "SWUNG", "SYRUP",
         "TABLE", "TABOO", "TACIT", "TAKEN", "TALON", "TANGY", "TAPER", "TAPIR", "TARDY", "TASTE", "TASTY", "TAUNT", "TAWNY", "TEARY", "TEASE", "TEMPO", "TENTH", "TEPID", "TERSE", "THEIR", "THEME", "THERE", "THESE", "THIEF", "THIGH", "THING", "THINK", "THIRD", "THORN", "THOSE", "THREE", "THREW", "THROW", "THUMB", "THUMP", "THYME", "TIARA", "TIBIA", "TIDAL", "TIGER", "TILDE", "TIPSY", "TITAN", "TITHE", "TODAY", "TONIC", "TOPAZ", "TOPIC", "TORSO", "TOTEM", "TOUCH", "TOUGH", "TOWEL", "TOXIC", "TOXIN", "TRACE", "TRACT", "TRADE", "TRAIN", "TRAIT", "TRASH", "TRAWL", "TREAT", "TREND", "TRIAD", "TRICE", "TRITE", "TROLL", "TROPE", "TROVE", "TRUSS", "TRUST", "TRUTH", "TRYST", "TUTOR", "TWANG", "TWEAK", "TWEED", "TWICE", "TWINE", "TWIRL", "ULCER", "ULTRA", "UNCLE", "UNDER", "UNDUE", "UNFED", "UNFIT", "UNIFY", "UNITE", "UNLIT", "UNMET", "UNTIE", "UNTIL", "UNZIP", "UPSET", "URBAN", "USAGE", "USHER", "USING", "USUAL", "USURP", "UTTER", "VAGUE", "VALET", "VALUE", "VALID", "VAPID", "VAULT", "VENOM", "VERGE", "VERVE", "VIDEO", "VIGOR", "VIOLA", "VIRAL", "VITAL", "VIVID", "VODKA", "VOICE", "VOILA", "VOTER", "VOUCH", "WACKY", "WALTZ", "WASTE", "WATCH", "WEARY", "WEDGE", "WHACK", "WHALE", "WHEEL", "WHELP", "WHERE", "WHICH", "WHIFF", "WHILE", "WHINE", "WHINY", "WHIRL", "WHISK", "WHOOP", "WINCE", "WINDY", "WOKEN", "WOMAN", "WOOER", "WORDY", "WORLD", "WORRY", "WORSE", "WORST", "WOULD", "WOVEN", "WRATH", "WRIST", "WRITE", "WRONG", "WROTE", "WRUNG", "YACHT", "YEARN", "YIELD", "YOUNG", "YOUTH", "ZEBRA", "ZESTY"};
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String answer = words[new Random().nextInt(words.length)].toUpperCase();
        
        System.out.println("Welcome to Wordle: Java Version!");
        System.out.println("\tCorrectly guess the five-letter word in 6 guesses and you win!\n");

        //Allow the user 6 attempts
        for(int attempt = 0; attempt < 6; attempt++) {
            System.out.print("Enter your guess: ");
            String guess = input.nextLine().toUpperCase();

            if (guess.length() != answer.length()) {
                System.out.println("Your guess must be " + answer.length() + " letters long.");
                //Don't count this as a valid attempt
                attempt--;
                continue;
            }

            StringBuilder result = new StringBuilder();

            //Check each letter
            for (int i = 0; i < guess.length(); i++) {
                char c = guess.charAt(i);

                if (c == answer.charAt(i)) {
                    //Correct letter in the correct position
                    result.append(ANSI_GREEN).append(c).append(ANSI_RESET);
                } else if (answer.indexOf(c) >= 0) {
                    //Correct letter in the wrong position
                    result.append(ANSI_YELLOW).append(c).append(ANSI_RESET);
                } else {
                    //Incorrect letter
                    result.append(c);
                }
            }

            //Print the result of the guess
            System.out.println(result.toString());

            //Check if the guess is correct
            if (guess.equals(answer)) {
                System.out.println("Congratulations! You guessed the word correctly.");
                //End the game if the guess is correct
                return;
            }
        }

        System.out.println("Sorry, you've used all your attempts. The correct word was " + answer);
        input.close();
    }

}
