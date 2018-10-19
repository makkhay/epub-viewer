package net.jspiner.epub_viewer.ui.reader.strategy

import net.jspiner.epub_viewer.dto.PageInfo
import net.jspiner.epub_viewer.ui.reader.ReaderViewModel
import net.jspiner.epub_viewer.ui.reader.viewer.EpubPagerAdapter
import net.jspiner.epub_viewer.ui.reader.viewer.VerticalViewPager

abstract class ViewerTypeStrategy(protected val viewModel: ReaderViewModel) {

    protected val pageInfo: PageInfo
        get() = viewModel.getCurrentPageInfo()

    abstract fun changeViewPagerOrientation(verticalViewPager: VerticalViewPager)

    abstract fun getAllPageCount(): Int

    abstract fun setCurrentPagerItem(
        pager: VerticalViewPager,
        adapter: EpubPagerAdapter,
        currentPage: Int
    )

    abstract fun onPagerItemSelected(pager: VerticalViewPager, adapter: EpubPagerAdapter, position: Int)
}