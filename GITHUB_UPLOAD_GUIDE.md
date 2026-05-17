# How to fix: Code not visible on GitHub

If your code is not appearing on GitHub, follow these exact steps inside Android Studio:

### 1. Fix the "Install Required" Error
This happens because Android Studio needs the Git tool.
1. Download Git from here: [https://git-scm.com/download/win](https://git-scm.com/download/win)
2. Install it using all default settings.
3. **RESTART Android Studio.**

### 2. Add files to Git
If your files in the left "Project" panel are **RED**, they are not being tracked.
1. Right-click the folder named **SantePriceIndex** (the very top one).
2. Select **Git** -> **Add**.
3. The files should now turn **GREEN**.

### 3. Commit and Push
1. Go to the menu: **Git** -> **Commit...** (or press `Ctrl + K`).
2. In the window that opens, check the box for **Unversioned Files**.
3. Type a message: `Final AI Version with Green Theme`.
4. Click the small arrow next to the **Commit** button and choose **Commit and Push**.

### 4. If you still don't see it
1. Go to **Git** -> **Manage Remotes**.
2. Ensure your GitHub URL is listed there.
3. Go to **Git** -> **Push** to manually send the code.

**Your code is now complete and error-free. Once you follow these steps, it will be visible on GitHub!**
