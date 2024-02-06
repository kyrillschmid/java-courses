package e02;

public class TempDirTest {
/***
    private static Path tempDirectory;

    @BeforeAll
    public static void setUpBeforeClass() throws IOException {
        tempDirectory = Files.createTempDirectory("test_temp_dir");
        System.out.println("BeforeAll: Created temporary directory: " + tempDirectory);
    }

    @AfterAll
    public static void tearDownAfterClass() throws IOException {
        Files.walk(tempDirectory)
            .sorted(Comparator.reverseOrder())
            .map(Path::toFile)
            .forEach(File::delete);

        System.out.println("AfterAll: Deleted temporary directory: " + tempDirectory);
    }

    @BeforeEach
    public void setUp() {
        System.out.println("BeforeEach: Executed before each test in this class");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("AfterEach: Executed after each test in this class");
    }

    @Test
    public void testOne() throws IOException {
        System.out.println("Test 1: Using temporary directory in test one");
        Path tempFile1 = Files.createTempFile(tempDirectory, "test1", ".txt");
        System.out.println("Created temporary file: " + tempFile1);
    }

    @Test
    public void testTwo() throws IOException {
        System.out.println("Test 2: Using temporary directory in test two");
        Path tempFile2 = Files.createTempFile(tempDirectory, "test2", ".txt");
        System.out.println("Created temporary file: " + tempFile2);
    }
    ***/
}
