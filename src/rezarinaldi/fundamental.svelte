<script>
    import { fade, fly } from "svelte/transition";
    import EmojiDisplay from "./EmojiDisplay.svelte";
    import EmojiDescription from "./EmojiDescription.svelte";
    import Button from "./Button.svelte";
    import { theme } from "./theme.js";
    $: dark = $theme === "Dark";
    let isLoaded = false;
    let currentEmoji = "😃";
    const emojis = ["🤣", "😺", "🛹", "🚀"];
    let m = { x: 0, y: 0 };
    function toggleTheme() {
      // jika di localStorage tidak ada data tema maka ganti tema menjadi tema Gelap
      const newTheme =
        $theme === null ? "Dark" : $theme === "Light" ? "Dark" : "Light";
      theme.set(newTheme);
      localStorage.setItem("theme", newTheme);
    }
    function randomizeEmoji() {
      return emojis[Math.floor(Math.random() * emojis.length)];
    }
    function handleRandomButton() {
      currentEmoji = randomizeEmoji();
    }
    setTimeout(function() {
      isLoaded = true;
    }, 2500);
    function handleMouseMove(event) {
      m.x = event.clientX;
      m.y = event.clientY;
    }
  </script>
  
  <style>
    .button-switch-theme {
      padding: 0.25em;
      padding-left: 0.5em;
      padding-right: 0.5em;
      border-radius: 1em;
      display: inline-block;
      background: #eee;
      cursor: pointer;
    }
    .dark {
      background: #162a44;
      color: #fff;
    }
    :global(body.dark-mode) main {
      color: #ffffff;
    }
    main {
      position: relative;
      max-width: 56em;
      padding: 2em;
      margin: 0 auto;
      box-sizing: border-box;
    }
    @media (max-width: 480px) {
      /* smartphones, portrait iPhone, portrait 480x320 phones (Android) */
      main {
        padding: 0.5em;
      }
    }
  </style>
  
  <svelte:head>
    <link rel="stylesheet" href="./terminal.min.css" />
  </svelte:head>
  
  <main>
    <nav class="terminal-nav">
      <header class="terminal-logo">
        <div class="terminal-prompt">
          <a href="/" class="no-style">🧽 Svelte app</a>
        </div>
      </header>
      <div class="terminal-menu">
        <ul typeof="BreadcrumbList">
          {#if $theme !== null}
            <li>
              <span on:click={toggleTheme} class="button-switch-theme" class:dark>
                {$theme === 'Dark' ? '🌜 ' + $theme : '🌞 ' + $theme}
              </span>
            </li>
          {/if}
        </ul>
      </div>
    </nav>
  
    <div class="container" on:mousemove={handleMouseMove}>
      <p>The mouse position: {m.x} x {m.y}</p>
      <h1>Randomize Emoji</h1>
      <ul>
        {#each emojis as emoji}
          <li>{emoji}</li>
        {/each}
      </ul>
      {#if isLoaded === true}
        <div in:fly={{ y: 200, duration: 2000 }} out:fade>
          <EmojiDisplay {currentEmoji} />
          <EmojiDescription />
          <Button on:click={handleRandomButton} title={'🔁 Randomize'} />
        </div>
      {:else}
        <h2>Loading...</h2>
      {/if}
  
      <Button title={'Toggle'} on:click={() => (isLoaded = !isLoaded)} />
    </div>
  </main>