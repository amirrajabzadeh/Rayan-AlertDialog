
# Rayan-AlertDialog

[![](https://jitpack.io/v/amirrajabzadeh/Rayan-AlertDialog.svg)](https://jitpack.io/#amirrajabzadeh/Rayan-AlertDialog)

This is an Android Library for showing AlertDialog with little customization with title, colors, custom loading, icon.
Example is available in app module.

![Gif Sample ](https://raw.githubusercontent.com/amirrajabzadeh/Rayan-AlertDialog/master/Screenshot/Screenshot1.gif)

![Screenshot Sample](https://github.com/amirrajabzadeh/Rayan-AlertDialog/blob/master/Screenshot/Screenshot2.png?raw=true)
## Download

### Gradle dependency:

- Add the following to your project level build.gradle:
```bash
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```


- Add this to your app build.gradle:
```bash
dependencies {

	implementation 'com.github.amirrajabzadeh:Rayan-AlertDialog:1.0.0'

}
```

### Usage

Create Builder Pattern for default Dialog.

- Default Dialog has "Title" as dialog title, "Content Description" as content, "Yes" & "No" buttons.

```java
RayanAlert alert = new RayanAlert(this);

alert
	.show(new RayanAlert.OnClickListener() {
	     @Override
	     public void onPositiveButtonClick() {
         
	     }
	});
```

- Add Title
  > `.setTitle(String title)`

```java
RayanAlert alert = new RayanAlert(this);

alert
	.setTitle("Title")
	.show(new RayanAlert.OnClickListener() {
	     @Override
	     public void onPositiveButtonClick() {
         
	     }
	});
```

- Set Color Title
  > `.setColorTitle(int color)`

```java
RayanAlert alert = new RayanAlert(this);

alert
	.setTitle("Title")
	.setColorTitle(Color.WHITE)
	.show(new RayanAlert.OnClickListener() {
	     @Override
	     public void onPositiveButtonClick() {
         
	     }
	});
```

- Set Title  Background Color
  > `.setTitleBackground(int color)`

```java
RayanAlert alert = new RayanAlert(this);

alert
	.setTitle("Title")
	.setColorTitle(Color.WHITE)
	.setTitleBackground(Color.GREEN)
	.show(new RayanAlert.OnClickListener() {
	     @Override
	     public void onPositiveButtonClick() {
         
	     }
	});
```

- Add Message
  > `.setMessage(String title)`

```java
RayanAlert alert = new RayanAlert(this);

alert
	.setTitle("Title")
	.setColorTitle(Color.WHITE)
	.setTitleBackground(Color.GREEN)
	.setMessage("Message")
	.show(new RayanAlert.OnClickListener() {
	     @Override
	     public void onPositiveButtonClick() {
         
	     }
	});
```

- Set Message Color
  > `.setColorMessage(int color)`

```java
RayanAlert alert = new RayanAlert(this);

alert
	.setTitle("Title")
	.setColorTitle(Color.WHITE)
	.setTitleBackground(Color.GREEN)
	.setMessage("Message")
	.setColorMessage(Color.BLUE)
	.show(new RayanAlert.OnClickListener() {
	     @Override
	     public void onPositiveButtonClick() {
         
	     }
	});
```
