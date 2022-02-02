package org.dastanapps.opencv.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.dastanapps.opencv.android.screen.Chapters
import org.dastanapps.opencv.android.screen.Home
import org.dastanapps.opencv.android.screen.ShowTutorial
import org.dastanapps.opencv.android.screen.Tutorials
import org.dastanapps.opencv.android.tutorials.mocva.Chapter1Blur
import org.dastanapps.opencv.android.vm.Chapter
import org.dastanapps.opencv.android.vm.MainViewModel
import org.dastanapps.opencv.android.vm.Tutorial

/**
 *
 * "Iqbal Ahmed" created on 30/01/2022
 */


sealed class NavGraph(val route: String) {
    object Home : NavGraph("home")
    object Chapters : NavGraph("chapters")
    object Tutorials : NavGraph("tutorials")
    object ShowTutorial : NavGraph("show_tutorial")

    fun withArgs(vararg args: String) = buildString {
        append(route)
        args.forEach {
            append("/$it")
        }
    }
}


@Composable
fun Navigation(
    navController: NavHostController,
    viewModel: MainViewModel
) {
    NavHost(
        navController = navController,
        startDestination = NavGraph.Home.route
    ) {

        composable(NavGraph.Home.route) {
            Home(viewModel.sources) {
                navController.navigate(it)
            }
        }

        composable(NavGraph.Chapters.route.plus("/{name}/{id}")) {
            val id = it.arguments?.getString("id")?.toInt()!!
            val name = it.arguments?.getString("name")
            val list = viewModel.chapters[id] as List<Chapter>
            Chapters(name!!, list, navController) {
                navController.navigate(it)
            }
        }

        composable(NavGraph.Tutorials.route.plus("/{name}/{chapterId}")) {
            val chapterId = it.arguments?.getString("chapterId")?.toInt()
            val name = it.arguments?.getString("name")
            val list = viewModel.tutorials[chapterId] as List<Tutorial>
            Tutorials(name!!, chapterId!!, list, navController) {
                navController.navigate(it)
            }

        }

        composable(NavGraph.ShowTutorial.route.plus("/{name}/{chapterId}/{tutorialId}")) {
            val chapterId = it.arguments?.getString("chapterId")?.toInt()
            val tutorialId = it.arguments?.getString("tutorialId")?.toInt()
            val name = it.arguments?.getString("name")
            val list = viewModel.tutorial(chapterId!!, tutorialId!!)
            list?.first()?.run {
                when (this.id) {
                    111 -> Chapter1Blur(name!!, navController)
                    else -> ShowTutorial(name!!, this, navController)
                }
            }
        }
    }
}