(The file `d:\Thiago\workspace\teratorns\README.md` exists, but is empty)
**Teratorns — Simulação de Enxame (Boids/PSO) em LibGDX**

Projeto de exemplo em LibGDX que implementa uma simulação de enxame/boids com influências do tipo PSO (Particle Swarm Optimization) e interações por clique.

**Resumo:**
- **O que faz:** : simula agentes (pássaros/boids) que se movem tentando alcançar uma fonte de alimento definida pelo usuário, combinando inércia, comportamento individual (pBest), comportamento de grupo (lBest) e ruído aleatório.
- **Plataformas suportadas:** : desktop, Android e web (GWT) através da estrutura multi-modular do projeto.

**Arquitetura (núcleo - core/)**
- **`GameRun`**: inicializa o jogo, carrega assets e seta a tela principal. ([core/src/com/teratorns/GameRun.java](core/src/com/teratorns/GameRun.java))
- **`AssetsLoader`**: carregamento e disposição de texturas, fontes e atlas usados pela aplicação. ([core/src/com/teratorns/assets/AssetsLoader.java](core/src/com/teratorns/assets/AssetsLoader.java))
- **Tela e fluxo**: `GameScreen` monta o mundo, a lógica e as views; gerencia o loop de atualização e render. ([core/src/com/teratorns/screens/GameScreen.java](core/src/com/teratorns/screens/GameScreen.java))
- **Renderização**: `GameRenderer` centraliza câmeras, SpriteBatch e render loop. ([core/src/com/teratorns/game/GameRenderer.java](core/src/com/teratorns/game/GameRenderer.java))
- **Mundo e lógica**: `GameWorld` contém um `Swarm` com partículas; `GameLogic` atualiza o mundo cada frame. ([core/src/com/teratorns/game/GameWorld.java](core/src/com/teratorns/game/GameWorld.java), [core/src/com/teratorns/game/GameLogic.java](core/src/com/teratorns/game/GameLogic.java))
- **Agentes (boids)**: `Bird`, `Swarm` e `SwarmConstants` definem comportamento, população e parâmetros (c1,c2,c3,raio,threshold). ([core/src/com/teratorns/objects/Bird.java](core/src/com/teratorns/objects/Bird.java))
- **Interação/Input**: `InputHelper` trata cliques/scroll; `InteractionHelper` converte clique em posição de mundo e posiciona a `FoodSource` para a qual os boids são atraídos. ([core/src/com/teratorns/helpers/InputHelper.java](core/src/com/teratorns/helpers/InputHelper.java), [core/src/com/teratorns/helpers/InteractionHelper.java](core/src/com/teratorns/helpers/InteractionHelper.java))
- **GUI / Views**: sistema simples de `View`/`ViewManager` e elementos de GUI (botões, TextArea, containers) para HUD e edição.

**Comportamento principal**
- Ao iniciar, `GameWorld` cria um enxame com `SwarmConstants.swarmSize` partículas.
- O usuário clica na tela para definir a posição de `FoodSource.food`; cada `Bird` calcula uma função de 'fitness' (distância até a comida) e aplica vectores de influência:
	- inércia (velocidade atual),
	- atração ao `pBest` (melhor posição individual),
	- atração ao `lBest` (melhor posição entre vizinhos dentro de `raio`),
	- componente aleatória ponderada por `c3`.

**Controles (padrão)**
- Clique: define fonte de alimento / interação com agentes.
- Scroll do mouse: altera `viewportWidth` (zoom).

**Como compilar/executar**
- Executar no desktop (Windows):

```bash
gradlew.bat :desktop:run
```

- Ou no WSL / Git Bash / Linux-like (já mostrada anteriormente):

```bash
./gradlew :desktop:run
```

- Compilar APK Android (se SDK configurado):

```bash
gradlew.bat :android:assembleDebug
gradlew.bat :android:installDebug
```

- Build para web (GWT):

```bash
./gradlew :html:superDev  # ou tarefas de build do módulo html
```

Observação: adapte comandos para seu ambiente (Windows vs POSIX). Verifique `local.properties` em `android/` apontando para o SDK.

**Estrutura de pastas (relevante)**
- `core/` : código independente de plataforma (gameplay, lógica, assets comuns).
- `desktop/`, `android/`, `html/` : módulos específicos por plataforma.
- `android/assets` e `core/src/com/teratorns/assets` : gráficos, fontes e atlas usados pelo jogo.

