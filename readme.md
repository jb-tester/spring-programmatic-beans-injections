
### Programmatic bean problems:

- autowiring by completion doesn't work in the programmatically registered bean classes
  <img alt="img_1.png" height="300" src="img_1.png" width="650"/>
- autowiring by postfix template or quick fix don't work also
  <br/>https://youtrack.jetbrains.com/issue/IDEA-384894/Spring-programmatic-beans-registration-no-autowiring-by-completion-in-the-bean-classes
- strange 'null' labels in the AutowireBean... dialog for some beans (Bean1, Bean2)
  <img alt="img.png" height="300" src="img.png" width="250"/>
  <br/>https://youtrack.jetbrains.com/issue/IDEA-384897/Spring-programmatic-beans-registration-incorrect-entries-in-the-AutowireBeans...-dialog
- debugger: no runtime inlays for the (same as above) autowired beans
  <img alt="img_3.png" height="200" src="img_3.png" width="500"/>
  <br/>https://youtrack.jetbrains.com/issue/IDEA-384957/Spring-Debugger-runtime-bean-inlays-are-not-shown-for-some-programmatically-registered-beans-in-non-suspended-mode