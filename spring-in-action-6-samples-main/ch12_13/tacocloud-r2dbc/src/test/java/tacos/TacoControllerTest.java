@Test
public void testTacoController() {
    // 1. Mock or instantiate your repository
    TacoRepository tacoRepo = Mockito.mock(TacoRepository.class); 

    // 2. Instantiate the controller (Line ~35)
    TacoController controller = new TacoController(tacoRepo, null);

    // 3. Add your test assertions below...
}
